package lr8.tasks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLParser {

    private static final String URL = "https://quotes.toscrape.com/";
    private static final String OUTPUT_FILE = "src/lr8/tasks/quotes.txt";
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 2000;

    public static void main(String[] args) {
        Document doc = null;
        int attempt = 0;
        
        while (attempt < MAX_RETRIES && doc == null) {
            attempt++;
            try {
                System.out.println("Попытка подключения " + attempt);
                
                doc = Jsoup.connect(URL).get();
                
                System.out.println("Подключение успешно!\n");
                
            } catch (IOException e) {
                System.err.println("Ошибка при подключении (попытка " + attempt + "): " + e.getMessage());
                
                if (attempt < MAX_RETRIES) {
                    System.out.println("Повторная попытка");
                    try {
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.err.println("Ожидание прервано");
                        break;
                    }
                } else {
                    System.err.println("Не удалось подключиться после " + MAX_RETRIES + " попыток.");
                    return;
                }
            }
        }
        
        if (doc == null) {
            System.err.println("Не удалось получить HTML-код страницы");
            return;
        }
        
        // Парсинг цитат
        Elements quotes = doc.select(".quote");
        
        if (quotes.isEmpty()) {
            System.out.println("Цитаты не найдены");
            return;
        }
        
        System.out.println("Цитаты: " + quotes.size());
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE, false))) {
            writer.println("Цитаты: ");
            writer.println();
            
            int count = 0;
            for (Element quoteBlock : quotes) {
                if (count >= 10) break;
                
                String quoteText = quoteBlock.select(".text").first().text();
                String author = quoteBlock.select(".author").first().text();
                
                // Выводим в консоль
                System.out.println((count + 1) + ". Цитата: " + quoteText);
                System.out.println("   Автор: " + author);
                System.out.println();
                
                // Записываем в файл
                writer.println((count + 1) + ". Цитата: " + quoteText);
                writer.println("   Автор: " + author);
                writer.println();
                
                count++;
            }
            
            System.out.println("Данные успешно сохранены в файл: " + OUTPUT_FILE);
            
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
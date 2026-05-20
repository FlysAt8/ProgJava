package lr7.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        String folder = "src/lr7/tasks/";

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла (из пакета tasks): ");
        String fileName = folder + in.nextLine();

        System.out.print("Введите слово для поиска: ");
        String str = in.nextLine();
        in.close();

        searchInFile(fileName, str);

    }

    public static void searchInFile(String file, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            boolean found = false;
        
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains(str.toLowerCase())) {
                    System.out.println("Строка " + lineNumber + ": " + line);
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("Слово \"" + str + "\" не найдено в файле.");
            }
            
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}

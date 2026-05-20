package lr7.tasks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        String folder = "src/lr7/tasks/";

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла (в пакете tasks): ");
        String fileName = folder + in.nextLine();
        
        System.out.println("Введите текст для записи в файл: ");
        String text = in.nextLine();
        
        int charactersWritten = writeToFile(fileName, text);
        
        if (charactersWritten >= 0) {
            System.out.println("Записано символов: " + charactersWritten);
        }
        
        in.close();
    }
    
    public static int writeToFile(String fileName, String text) {
        int characterCount = 0;
        
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
            characterCount = text.length();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return -1;
        }
        
        return characterCount;
    }
}

package lr7.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        String inputFileName = "src/lr7/tasks/input.txt";

        try (BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(inputFileName))) {
            int count = 0;
            while (bufferedReader.readLine() != null) {
                count++;
            }
            bufferedReader.close();
            System.out.println("Количество строк: " + count);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}

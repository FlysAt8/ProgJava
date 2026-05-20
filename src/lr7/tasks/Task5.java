package lr7.tasks;

import java.io.File;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/tasks");

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла (из пакета tasks): ");
        String fileName = in.nextLine();
        in.close();

        File file = new File(folder, fileName);
        long file_size = file.length();
        System.out.println("Размер файла: " + file_size + " байт");
    }
}

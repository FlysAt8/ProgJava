package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите день недели: ");
        String ned = in.nextLine();

        System.out.print("Введите месяц: ");
        String mes = in.nextLine();

        System.out.print("Введите дату: ");
        int date = in.nextInt();

        System.out.println("Сегодняшняя дата: " + ned + " " + date + " " + mes);

        in.close();
    }
}

package lr1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите фамилию: ");
        String fam = in.nextLine();

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите отчество: ");
        String otch = in.nextLine();

        System.out.println("Hello, " + fam + " " + name + " " + otch);

        in.close();
    }
}

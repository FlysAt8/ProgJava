package lr1;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите возраст: ");
        int age = in.nextInt();

        int god = 2026 - age;

        System.out.println("Год рождения: " + god);

        in.close();
    }
}

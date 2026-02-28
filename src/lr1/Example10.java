package lr1;

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите год рождения: ");
        int god = in.nextInt();

        int age = 2026 - god;

        System.out.println("Возраст: " + age);

        in.close();
    }
}

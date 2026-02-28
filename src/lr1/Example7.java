package lr1;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input name: ");
        String name = in.nextLine();

        System.out.print("Input age: ");
        int age = in.nextInt();

        System.out.println("Info:");
        System.out.println("\tName: " + name);
        System.out.println("\tAge: " + age);

        in.close();
    }
}

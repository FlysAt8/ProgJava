package timus;

import java.util.Scanner;

public class task_1409 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int sum = a + b - 1;
        System.out.println((sum - a) + " " + (sum - b));

        in.close();
    }
}

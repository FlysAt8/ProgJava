package timus;

import java.util.Scanner;

public class task_2001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a, b;
        int buf_a, buf_b;

        a = in.nextInt();
        b = in.nextInt();

        buf_a = in.nextInt();
        buf_b = in.nextInt();

        b = b - buf_b;

        buf_a = in.nextInt();
        buf_b = in.nextInt();

        a = a-buf_a;

        System.out.println(a + " " + b);

        in.close();
    }
}

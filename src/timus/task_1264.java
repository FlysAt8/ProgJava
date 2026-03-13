package timus;

import java.util.Scanner;

public class task_1264 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        m++;

        System.out.println(n*m);

        in.close();
    }
}

package timus;

import java.util.Scanner;

public class task_1820 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int m;

        if (n <= 0) {
            m = 0;
        } else {
            m = (2 * n + k - 1) / k;
        }

        System.out.println(m);

        in.close();
    }
}

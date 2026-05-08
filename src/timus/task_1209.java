package timus;

import java.util.Scanner;

public class task_1209 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            long k = in.nextLong();

            long d = 1 + 8 * (k - 1);
            long sqrt = (long) Math.sqrt(d);

            if (sqrt*sqrt == d && sqrt % 2 == 1) {
                x[i] = 1;
            } else {
                x[i] = 0;
            }
        }

        for (int i : x) {
            System.out.print(i+" ");
        }

        in.close();
    }
}

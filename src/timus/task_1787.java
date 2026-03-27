package timus;

import java.util.Scanner;

public class task_1787 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int n = in.nextInt();
        int sum = 0;


        for (int i = 0; i < n; i++) {
            sum += in.nextInt();
        }

        if ((k*n-sum) < 0) {
            System.out.println(-1*(k*n-sum));
        } else System.out.println(0);

        in.close();
    }
}

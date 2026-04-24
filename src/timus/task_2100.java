package timus;

import java.util.Scanner;

public class task_2100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int x = 2;

        for (int i = 0; i < n; i++) {
            String s = in.next();

            if (s.contains("+")) {
                x += 2;
            } else {
                x += 1;
            }
        }

        if (x == 13) x++;

        System.out.println(x*100);

        in.close();
    }
}

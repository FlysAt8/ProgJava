package timus;

import java.util.Scanner;

public class task_1197 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.nextLine();
        int[] m = new int[N];

        for (int i = 0; i < N; i++) {
            int var = 8;
            String pos = in.nextLine();

            int x = pos.charAt(0) - 'a' + 1;
            int y = pos.charAt(1) - '0';

            if (x == 1 || x == 8) {
                var -= 4;
            } else if (x == 2 || x == 7) {
                var -= 2;
            }

            if (y == 1 || y == 8) {
                if (var == 4) {
                    var -= 2;
                } else if (var == 6){
                    var -= 3;
                } else {
                    var -= 4;
                }
            } else if (y == 2 || y == 7) {
                if (var == 4) {
                    var -= 1;
                } else if (var == 6){
                    var -= 2;
                } else {
                    var -= 2;
                }
            }
            m[i] = var;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(m[i]);
        }
        in.close();
    }
}

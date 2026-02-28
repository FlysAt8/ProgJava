package timus;

import java.util.Scanner;

public class task_2012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int f = in.nextInt();

        float x = ((12 - f) * 45) / 60f;

        if (x <= 4) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        in.close();
    }
}

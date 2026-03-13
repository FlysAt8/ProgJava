package timus;

import java.util.Scanner;

public class task_1877 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String x1 = in.nextLine();
        String x2 = in.nextLine();

        if (x1.charAt(3) % 2 == 0 || x2.charAt(3) % 2 == 1) {
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

        in.close();
    }
}

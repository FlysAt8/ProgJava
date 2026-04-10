package timus;

import java.util.Scanner;

public class task_2066 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int min = Integer.MAX_VALUE;

        min = Math.min(min, f(a,b,c));
        min = Math.min(min, f(a,c,b));
        min = Math.min(min, f(b,a,c));
        min = Math.min(min, f(b,c,a));
        min = Math.min(min, f(c,a,b));
        min = Math.min(min, f(c,b,a));

        System.out.println(min);

        in.close();
    }

    private static int f(int x, int y, int z) {
        int minExpr = Integer.MAX_VALUE;

        for (int op1 = 0; op1 < 3; op1++) {
            for (int op2 = 0; op2 < 3; op2++) {
                int res = calculate(x, y, z, op1, op2);
                if (res < minExpr) {
                    minExpr = res;
                }
            }
        }
        return minExpr;
    }

    private static int calculate(int x, int y, int z, int op1, int op2) {
        // 0='+', 1='-', 2='*'

        if (op1 == 2 && op2 == 2) {
            return x * y * z;
        } else if (op1 == 2) {
            int temp = x * y;
            if (op2 == 0) return temp + z;
            if (op2 == 1) return temp - z;
            return temp * z;
        } else if (op2 == 2) {
            int temp = y * z;
            if (op1 == 0) return x + temp;
            if (op1 == 1) return x - temp;
            return x * temp;
        } else {
            // Без умножения
            int temp;
            if (op1 == 0) temp = x + y;
            else temp = x - y;
            
            if (op2 == 0) return temp + z;
            return temp - z;
        }
    }
}

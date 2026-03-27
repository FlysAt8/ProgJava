package lr3.primers1;

public class Primer5 {
    private static int step = 0;

    public static int fib(int n) {
        
        space();
        step++;
        System.out.print("fib("+n+")=");

        if (n == 0) {   
            System.out.println(n);
        } else if (n == 1) {
            System.out.println(n);
        } else {
            System.out.println("fib("+(n-1)+")+fib("+(n-2)+")");
            int result = fib(n-1) + fib(n-2);
            step--;
            return result;
        }
        
        step--;
        return n;
    }

    private static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print("\t");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Вычисляем число Фибаначчи по номеру " + n + ":");
        int result = fib(n);
        System.out.println("Результат: " + result);
    }
}

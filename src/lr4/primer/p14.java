package lr4.primer;

public class p14 {
    public static int m(int x) throws ArithmeticException {
        int h = 10 / x;
        return h;
    }

    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива = " + l);
            System.out.println(m(l));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }
}

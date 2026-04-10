package lr4.primer;

public class p13 {
    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива = " + l);

            int h = 10 / l;
            args[l + 1] = "10";
            System.out.println(h); // добавил для логичности (зачем считаем h и не используем)
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль ");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }
}

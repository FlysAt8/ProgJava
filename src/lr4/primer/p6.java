package lr4.primer;

public class p6 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1 " + e);
        } catch (RuntimeException e) { // сначала ошибка у потомка
            System.out.println("2 " + e);
        } catch (Exception e) {
            System.out.println("3 " + e);
        }
        System.out.println("4");
    }
}

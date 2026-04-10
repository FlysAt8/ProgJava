package lr4.primer;

public class p7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e);
            try {
                throw new ArithmeticException(); // изначально не обрабатывается 
            } catch (ArithmeticException a) {
                System.out.println("2 " + a);
            }
        } 
        System.out.println("3");
    }
}

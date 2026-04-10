package lr4.primer;

public class p8 {
    public static int m() { // небыло return
        try {
            System.out.println("0");
            throw new RuntimeException();
        } catch (RuntimeException e) { // Добавили исключение
            System.out.println("1 " + e);
            return 0; 
        } finally {
            System.out.println("2");
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}

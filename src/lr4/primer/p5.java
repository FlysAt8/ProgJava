package lr4.primer;

public class p5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (RuntimeException e) { // небыло нужного
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}

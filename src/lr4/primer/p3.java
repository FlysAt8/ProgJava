package lr4.primer;

public class p3 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e);
        } catch (RuntimeException e) {
            System.out.println("2 " + e);
        } catch (Exception e) {
            System.out.println("3 " + e);
        }
        System.out.println("4");
    }
}

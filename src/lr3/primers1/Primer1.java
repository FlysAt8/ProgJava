package lr3.primers1;

public class Primer1 {
    public static void m(int x) {
        System.out.print(x + " ");
        if ((2 * x + 1) < 20) {
            m(2 * x + 1);
        }
    }

    public static void main(String[] args) {
        m(1);
        System.out.println();
    }
}

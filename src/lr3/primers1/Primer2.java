package lr3.primers1;

public class Primer2 {
    public static void m(int x) {
        if ((2 * x + 1) < 20) {
            m(2 * x + 1);
        }
        System.out.print(x + " ");
    }

    public static void main(String[] args) {
        m(1);
        System.out.println();
    }
}

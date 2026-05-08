package lr6;

public class Example4 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int threadNumber = i+1;
            Thread thread = new Thread(() -> System.out.println("Поток №"+threadNumber));
            thread.start();
        }
    }
}

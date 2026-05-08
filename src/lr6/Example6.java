package lr6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Example6 {
    public static void main(String[] args) throws InterruptedException {

        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) array[i] = random.nextInt(1000);

        int cores = Runtime.getRuntime().availableProcessors();

        int chunk = array.length / cores;
        int remainder = array.length % cores;

        List<Integer> sums = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < cores; i++) {

            final int start = i * chunk;
            final int end;
            if (i == cores - 1) {
                end = start + chunk + remainder;
            } else {
                end = start + chunk;
            }
            Thread thread = new Thread(() -> {
                int sum = findSum(array, start, end);
                synchronized (sums) {
                    sums.add(sum);
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int globalSum = sums.get(0);
        for (int i = 1; i < sums.size(); i++) {
            globalSum += sums.get(i);
        }
        
        System.out.println("Сумма (многопоточность): " + globalSum);

        int checkSum = findSum(array, 0, array.length);
        System.out.println("Сумма (обычный): " + checkSum);
    }

    public static int findSum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}

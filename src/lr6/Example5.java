package lr6;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Example5 {
    public static void main(String[] args) throws InterruptedException {

        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) array[i] = random.nextInt(1000);

        int cores = Runtime.getRuntime().availableProcessors();

        int chunk = array.length / cores;
        int remainder = array.length % cores;

        List<Integer> maxes = new ArrayList<>();
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
                int max = findMax(array, start, end);
                synchronized (maxes) {
                    maxes.add(max);
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int globalMax = maxes.get(0);
        for (int i = 1; i < maxes.size(); i++) {
            if (maxes.get(i) > globalMax) globalMax = maxes.get(i);
        }
        
        System.out.println("Максимум (многопоточность): " + globalMax);

        int checkMax = findMax(array, 0, array.length);
        System.out.println("Максимум (обычный): " + checkMax);
    }

    public static int findMax(int[] array, int start, int end) {
        int max = array[start];
        for (int i = start; i < end; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }
}

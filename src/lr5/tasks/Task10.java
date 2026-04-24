package lr5.tasks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = in.nextInt();
        int[] arr = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(200);
        }

        System.out.println("Массив arr:");
        System.out.println(Arrays.toString(arr));

        System.out.print("Введите число для фильтра: ");
        int number = in.nextInt();

        int[] arrResult = filterEvenNumbers(arr, number);

        System.out.println("Массив arrResult:");
        System.out.println(Arrays.toString(arrResult));

        in.close();
    }

    public static int[] filterEvenNumbers(int[] arr, int number) {
        return Arrays.stream(arr).filter(x -> x < number).toArray();
    }
}

package lr2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mincount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = in.nextInt();

        System.out.println("Размер массива - " + size);
        int[] nums = new int[size];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(50);
            System.out.println("Элемент [" + i + "] = " + nums[i]);
        }
        
        int[] buf = new int[nums.length];

        for (int i = 0; i < buf.length; i++){
            buf[i] = nums[i];
        }

        Arrays.sort(buf);
        System.out.println("Произведена сортировка массива");

        for (int i = 0; i < buf.length; i++){
            System.out.println("Элемент [" + i + "] = " + buf[i]);
        }

        System.out.println("\nМинимальный элемент - " + buf[0]);
        System.out.print("Начальный(ые) индекс(ы): ");
        for (int i = 0; i < nums.length; i++){
            if (buf[0] == nums[i]){
                System.out.print(i + " ");
            }
        }

        in.close();
    }
}

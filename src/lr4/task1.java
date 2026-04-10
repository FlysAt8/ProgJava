package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int l = in.nextInt();

            if (l <= 0) {
                throw new IllegalArgumentException(); // для включения 0
            }
            int[] m = new int[l];

            for (int i = 0; i < l; i++) {
                m[i] = in.nextInt();
            }

            int count = 0;
            int sum = 0;
            for (int num : m) {
                if (num > 0) {
                    sum += num;
                    count++;
                }
            }

            if (count == 0) throw new ArithmeticException();

            float avg = (float) sum / count;

            System.out.println("Среднее арифметическое положительных элементов: " + avg);

        } catch (InputMismatchException e) {
            System.out.println("Нужно вводить числа!");
        } catch (IllegalArgumentException e) {
            System.out.println("Массив должен быть положительного размера!");
        } catch (ArithmeticException e){
            System.out.println("Нет положительных чисел!");
        } finally {
            in.close();
        }
    }
}

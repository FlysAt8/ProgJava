package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            int sum = 0;
            System.out.print("Введите размер массива: ");
            int l = in.nextInt();

            if (l <= 0) {
                throw new IllegalArgumentException(); // для включения 0
            }
            byte[] m = new byte[l];

            System.out.println("Введите элементы типа byte (-128:127)");
            for (int i = 0; i < l; i++) {
                int x = in.nextInt();
                if (x < Byte.MIN_VALUE || x > Byte.MAX_VALUE) {
                    throw new NumberFormatException();
                }
                m[i] = (byte) x;
                if (sum + m[i] < Byte.MIN_VALUE || sum + m[i] > Byte.MAX_VALUE) {
                    throw new ArithmeticException();
                }
                sum += m[i];
            }
            System.out.println("Сумма элементов: " + sum);

        } catch (NumberFormatException e) {
            System.out.println("Нужно вводить числа типа byte!");
        } catch (ArithmeticException e) {
            System.out.println("Сумма элементов не входит в диапазон типа byte!");
        } catch (InputMismatchException e) {
            System.out.println("Нужно вводить числа!");
        } catch (IllegalArgumentException e) {
            System.out.println("Массив должен быть положительного размера!");
        } finally {
            in.close();
        }
    }
}

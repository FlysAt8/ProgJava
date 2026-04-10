package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Создание матрицы с числами");
            System.out.println("Введите размеры мартицы: ");
            System.out.print("\tКоличество строк: ");
            int x = in.nextInt();
            System.out.print("\tКоличество столбцов: ");
            int y = in.nextInt();

            if (x <= 0 || y <= 0) {
                throw new IllegalArgumentException(); // для включения 0
            }
            int[][] m = new int[x][y];

            System.out.println("Вводите массив:");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    m[i][j] = in.nextInt();
                }
            }

            System.out.print("Введите номер столбца для вывода (0-"+(y-1)+"): ");
            int col = in.nextInt();
            if (col < 0 || col >= y) throw new ArrayIndexOutOfBoundsException();

            for (int i = 0; i < x; i++) {
                System.out.println(m[i][col]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Нужно вводить числа!");
        } catch (IllegalArgumentException e) {
            System.out.println("Матрица должена быть положительного размера!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Нет такого столбца!");
        } finally {
            in.close();
        }
    }
}

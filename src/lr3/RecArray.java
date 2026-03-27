package lr3;

import java.util.Scanner;

public class RecArray {

    public static void inputArray(int[] arr, int index, Scanner scanner) {
        if (index == arr.length) {
            return;
        }
        System.out.print("Введите элемент [" + index + "]: ");
        arr[index] = scanner.nextInt();
        inputArray(arr, index + 1, scanner);
    }

    public static void printArray(int[] arr, int index) {
        if (index == arr.length) {
            System.out.println();
            return;
        }
        System.out.print(arr[index] + " ");
        printArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] myArray = new int[size];

        System.out.println("Ввод элементов массива:");
        inputArray(myArray, 0, scanner);

        System.out.println("Вывод массива:");
        printArray(myArray, 0);

        scanner.close();
    }
}

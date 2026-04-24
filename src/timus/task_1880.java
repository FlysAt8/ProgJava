package timus;

import java.util.Arrays;
import java.util.Scanner;

public class task_1880 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = in.nextInt();
        }

        int n2 = in.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = in.nextInt();
        }

        int n3 = in.nextInt();
        int[] arr3 = new int[n3];
        for (int i = 0; i < n3; i++) {
            arr3[i] = in.nextInt();
        }

        int[] x = findCommonElements(arr1, arr2);
        x=findCommonElements(x, arr3);

        System.out.println(x.length);

        in.close();
    }

    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                    .filter(x -> Arrays.stream(arr2)
                    .anyMatch(y -> y == x))
                    .toArray();
    }
}

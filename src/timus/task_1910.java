package timus;

import java.util.Scanner;

public class task_1910 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        int maxSum = 0;
        int middleIndex = 0;
        
        for (int i = 1; i < n - 1; i++) {
            int sum = a[i - 1] + a[i] + a[i + 1];
            if (sum > maxSum) {
                maxSum = sum;
                middleIndex = i;
            }
        }
        
        System.out.println(maxSum + " " + (middleIndex + 1));
        
        scanner.close();
    }
}

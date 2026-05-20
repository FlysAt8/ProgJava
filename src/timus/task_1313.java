package timus;

import java.util.Scanner;

public class task_1313 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        int[][] matrix = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        for (int sum = 0; sum < 2 * N - 1; sum++) {
            int startRow = Math.max(0, sum - (N - 1));
            int endRow = Math.min(N - 1, sum);
            
            for (int i = endRow; i >= startRow; i--) {
                int j = sum - i;
                System.out.print(matrix[i][j] + " ");
            }
        }
        
        scanner.close();
    }
}

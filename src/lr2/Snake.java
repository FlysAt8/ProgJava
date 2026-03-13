package lr2;

import java.util.Scanner;

public class Snake {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество столбцов массива: ");
        int size_x = in.nextInt();

        System.out.print("Введите количество рядов массива: ");
        int size_y = in.nextInt();
        
        int[][] mas = new int[size_y][size_x];

        for (int i = 0; i < size_y; i++){
            if (i % 2 == 0){
                for (int j = 0; j < size_x; j++){
                    for (int y = 0; y < size_y; y++){
                        for (int x = 0; x < size_x; x++){
                            System.out.print(mas[y][x]+" ");
                        }
                        System.out.println();
                    }
                    mas[i][j] = 1;
                    System.out.println();
                }
            } else {
                for (int j = size_x-1; j >= 0; j--){
                    for (int y = 0; y < size_y; y++){
                        for (int x = 0; x < size_x; x++){
                            System.out.print(mas[y][x]+" ");
                        }
                        System.out.println();
                    }
                    mas[i][j] = 1;
                    System.out.println();
                }
            }

        }
        for (int y = 0; y < size_y; y++){
            for (int x = 0; x < size_x; x++){
                System.out.print(mas[y][x]+" ");
            }
            System.out.println();
        }


        in.close();
    }
}

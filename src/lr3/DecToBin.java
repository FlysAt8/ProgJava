package lr3;

import java.util.Scanner;

public class DecToBin {

    public static void decbin(int x){
        if (x <= 0) return;
        decbin(x / 2);
        System.out.print(x % 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("DEC: ");
        int dec = in.nextInt();
        System.out.print("BIN: ");
        decbin(dec);
        in.close();
    }
}

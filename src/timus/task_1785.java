package timus;

import java.util.Scanner;

public class task_1785 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();

        if (x >= 1 && x <= 4) {System.out.println("few");}
        if (x >= 5 && x <= 9) {System.out.println("several");}
        if (x >= 10 && x <= 19) {System.out.println("pack");}
        if (x >= 20 && x <= 49) {System.out.println("lots");}
        if (x >= 50 && x <= 99) {System.out.println("horde");}
        if (x >= 100 && x <= 249) {System.out.println("throng");}
        if (x >= 250 && x <= 499) {System.out.println("swarm");}
        if (x >= 500 && x <= 999) {System.out.println("zounds");}
        if (x >= 1000) {System.out.println("legion");}

        in.close();
    }
}

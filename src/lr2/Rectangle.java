package lr2;

import java.util.Scanner;

public class Rectangle {
    int length;
    int width;

    public void setLength(int length){
        this.length = length;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getLength(){
        return this.length;
    }
    public int getWidth(){
        return this.width;
    }
    public int getPerimeter(){
        int perimeter = (this.length+this.width)*2;
        return perimeter;
    }
        public int getArea(){
        int area = this.length*this.width;
        return area;
    }
    public Rectangle(){
    }
    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Rectangle rect = new Rectangle();

        System.out.print("Введите длину: ");
        rect.length = in.nextInt();

        System.out.print("Введите ширину: ");
        rect.width = in.nextInt();

        System.out.println("Параметры: ");
        System.out.println("Длина - " + rect.getLength());
        System.out.println("Ширина - " + rect.getWidth());
        System.out.println("Периметр - " + rect.getPerimeter());
        System.out.println("Площадь - " + rect.getArea());

        System.out.println("\nВторой прямоугольник");
        Rectangle rect2 = new Rectangle(5, 10);

        System.out.println("Параметры: ");
        System.out.println("Длина - " + rect2.getLength());
        System.out.println("Ширина - " + rect2.getWidth());
        System.out.println("Периметр - " + rect2.getPerimeter());
        System.out.println("Площадь - " + rect2.getArea());

        in.close();
    }
}

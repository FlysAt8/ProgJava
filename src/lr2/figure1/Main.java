package lr2.figure1;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Square square = new Square(8);
        Triangle triangle = new Triangle(3, 4, 5);

        System.out.println(
            "Круг:\n\tПериметр: " + circle.calculatePerimeter() + "\n\tПлощадь: " + circle.calculateArea()
        );
        System.out.println(
            "\nКвадрат:\n\tПериметр: " + square.calculatePerimeter() + "\n\tПлощадь: " + square.calculateArea()
        );
        System.out.println(
            "\nТреугольник:\n\tПериметр: " + triangle.calculatePerimeter() + "\n\tПлощадь: " + triangle.calculateArea()
        );
    }
}

package lr2.figure2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        circle.getInfo();

        Square square = new Square(8);
        square.getInfo();
        
        Triangle triangle = new Triangle(3, 4, 5);
        triangle.getInfo();
    }
}

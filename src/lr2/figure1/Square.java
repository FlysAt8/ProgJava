package lr2.figure1;

public class Square implements Shape {
    float a; // сторона

    public Square(float a) {
        this.a = a;
    }

    @Override
    public float calculateArea() {
        return a * a;
    }

    @Override
    public float calculatePerimeter() {
        return a * 4;
    }
}

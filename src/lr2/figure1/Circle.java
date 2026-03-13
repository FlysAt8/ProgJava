package lr2.figure1;


public class Circle implements Shape {
    float r; // радиус

    public Circle(float r) {
        this.r = r;
    }

    @Override
    public float calculateArea() {
        return (float) (Math.PI * r * r);
    }

    @Override
    public float calculatePerimeter() {
        return (float) (2 * Math.PI * r);
    }
}

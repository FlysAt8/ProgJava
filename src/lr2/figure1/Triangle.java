package lr2.figure1;

public class Triangle implements Shape {
    float a;
    float b;
    float c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float calculateArea() {
        float s = (a + b + c) / 2;
        s = (float) Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return s;
    }

    @Override
    public float calculatePerimeter() {
        return a + b +c;
    }
}

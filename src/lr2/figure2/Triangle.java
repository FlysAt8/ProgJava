package lr2.figure2;

public class Triangle extends Shape{
    private float a, b, c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float area() {
        float s = (a + b + c) / 2;
        s = (float) Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return s;
    }

    @Override
    public float perimeter() {
        return a + b +c;
    }

    @Override
    public void getInfo() {
        System.out.println("Параметры треугольника");
        System.out.println("Длина стороны a: "+this.a);
        System.out.println("Длина стороны b: "+this.b);
        System.out.println("Длина стороны c: "+this.c);
        super.getInfo();
    }
}

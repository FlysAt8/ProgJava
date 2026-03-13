package lr2.figure2;

public class Square extends Shape {
    private float a;

    public Square(float a) {
        this.a = a;
    }

    @Override
    public float area() {
        return a * a;
    }

    @Override
    public float perimeter() {
        return 4 * a;
    }

    @Override
    public void getInfo() {
        System.out.println("Параметры квадрата");
        System.out.println("Длина стороны: "+this.a);
        super.getInfo();
    }
}

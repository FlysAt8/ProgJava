package lr2.figure2;

public class Circle extends Shape {
    private float r;

    public Circle(float r) {
        this.r = r;
    }

    @Override
    public float area() {
        return (float) (Math.PI * r * r);
    }

    @Override
    public float perimeter() {
        return (float) (2 * Math.PI * r);
    }

    @Override
    public void getInfo() {
        System.out.println("Параметры круга");
        System.out.println("Радиус: "+this.r);
        super.getInfo();
    }
}

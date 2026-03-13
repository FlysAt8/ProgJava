package lr2.figure2;

public abstract class Shape {
    public abstract float area();
    public abstract float perimeter();

    public void getInfo() {
        System.out.println("Площадь: " + area());
        System.out.println("Периметр: " + perimeter());
    }
}

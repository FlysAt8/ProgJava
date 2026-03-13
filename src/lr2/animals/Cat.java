package lr2.animals;

public class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+": Мяу");
    }

    @Override
    public String getInfo() {
        return super.getInfo()+", Цвет: "+this.color;
    }
}

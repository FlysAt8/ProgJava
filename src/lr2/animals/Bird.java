package lr2.animals;

public class Bird extends Animal{
    private boolean canfly;

    public Bird(String name, int age, boolean canfly) {
        super(name, age);
        this.canfly = canfly;
    }

    public void fly() {
        if (this.canfly) {
            System.out.println(getName() + " летит");
        } else {
            System.out.println(getName() + " не умеет летать");
        }
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+": Чирик");
    }

    @Override
    public String getInfo() {
        return super.getInfo()+", Умение летать: "+(this.canfly ? "Да" : "Нет");
    }
}

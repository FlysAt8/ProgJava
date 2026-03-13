package lr2.animals;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+": Гав");
    }

    @Override
    public String getInfo() {
        return super.getInfo()+", Порода: "+this.breed;
    }
}

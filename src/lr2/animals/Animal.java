package lr2.animals;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void makeSound() {
        System.out.println(this.name+": Звук животного");
    }

    public String getInfo() {
        return "Имя: "+this.name+", Возраст: "+this.age;
    }
}

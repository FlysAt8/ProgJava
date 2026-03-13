package lr2.animals;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик", 5, "Дворняга");
        System.out.println(dog.getInfo());
        dog.makeSound();

        Cat cat = new Cat("Мурзик", 3, "Рыжий");
        System.out.println(cat.getInfo());
        cat.makeSound();

        Bird bird = new Bird("Кеша", 1, true);
        System.out.println(bird.getInfo());
        bird.fly();
        bird.makeSound();
    }
}

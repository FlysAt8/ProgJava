package lr2;

import java.util.Scanner;

public class Person {
    String name;
    int age;
    String gender;

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getGender(){
        return this.gender;
    }

    public Person(){
    }
    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Создание пользователя");
        Person person = new Person();
        
        System.out.print("Введите имя: ");
        person.setName(in.nextLine());

        System.out.print("Введите возраст: ");
        person.setAge(in.nextInt());
        in.nextLine();

        System.out.print("Введите пол: ");
        person.setGender(in.nextLine());

        System.out.println();
        System.out.println("Информация о пользователе");
        System.out.println("Имя: "+ person.getName());
        System.out.println("Возраст: "+ person.getAge());
        System.out.println("Пол: "+ person.getGender());
        
        System.out.println("Пользователь через другой метод");
        Person person2 = new Person("Ivan", 20, "M");

        System.out.println("Информация о пользователе");
        System.out.println("Имя: "+ person2.getName());
        System.out.println("Возраст: "+ person2.getAge());
        System.out.println("Пол: "+ person2.getGender());

        in.close();
    }
}

package lr7.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        
        Person person = new Person(name, age);
        System.out.println("Создан объект: " + person);
        
        System.out.print("\nВведите имя файла для сохранения объекта: ");
        scanner.nextLine();
        String folder = "src/lr7/tasks/";
        String fileName = folder + scanner.nextLine();
        
        serializeObject(person, fileName);
        
        Person restoredPerson = deserializeObject(fileName);
        
        if (restoredPerson != null) {
            System.out.println("\nВосстановленный объект из файла");
            System.out.println("Имя: " + restoredPerson.getName());
            System.out.println("Возраст: " + restoredPerson.getAge());
        }
        
        scanner.close();
    }
    
    public static void serializeObject(Person person, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(person);
            System.out.println("\nОбъект успешно сохранен в файл: " + fileName);
            System.out.println("Размер файла: " + new File(fileName).length() + " байт");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении объекта: " + e.getMessage());
        }
    }
    
    public static Person deserializeObject(String fileName) {
        Person person = null;
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            person = (Person) ois.readObject();
            System.out.println("\nОбъект успешно восстановлен из файла: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Класс Person не найден: " + e.getMessage());
        }
        
        return person;
    }
}

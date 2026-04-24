package lr5.tasks;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) {
        String string = "Тут как будто Предложение из слов, с разным размером Букв";

        List<String> strings = List.of(string.split(" "));

        System.out.println("\nСтрока после сплита:\n");
        for (String s : strings) {
            System.out.println(s);
        }

        System.out.print("Введите необходимую длину:");
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        List<String> stringAfter = filterCapitalizerStrings(strings, length);

        System.out.println("\nСтроки после преобразования:\n");
        for (String s : stringAfter) {
            System.out.println(s);
        }

        in.close();
    }

    public static List<String> filterCapitalizerStrings(List<String> strings, int length) {
        return strings.stream()
                    .filter(s -> s.length() > length)
                    .collect(Collectors.toList());
    }
}

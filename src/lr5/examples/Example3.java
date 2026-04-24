package lr5.examples;

import java.util.List;
import java.util.stream.Collectors;

public class Example3 {
    public static void main(String[] args) {
        String string = "Тут как будто Предложение из слов, с разным размером Букв";

        List<String> strings = List.of(string.split(" "));

        System.out.println("\nСтрока после сплита:\n");
        for (String s : strings) {
            System.out.println(s);
        }

        List<String> stringAfter = filterCapitalizerStrings(strings);

        System.out.println("\nСтроки после преобразования:\n");
        for (String s : stringAfter) {
            System.out.println(s);
        }
    }

    public static List<String> filterCapitalizerStrings(List<String> strings) {
        return strings.stream()
                    .filter(s -> Character.isUpperCase(s.charAt(0)))
                    .collect(Collectors.toList());
    }
}

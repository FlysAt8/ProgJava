package lr5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    public static void main(String[] args) {
        String string = "Тут ка2к будт_о Предложение из слов, с раз2ным размером Букв";

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
                    .filter(s -> s.matches("[а-яА-Я]+"))
                    .collect(Collectors.toList());
    }
}

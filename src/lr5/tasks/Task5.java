package lr5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        String string = "Тут как будто Предложение из слов, с разным размером Букв";

        List<String> strings = List.of(string.split(" "));

        System.out.println("\nСтрока после сплита:\n");
        for (String s : strings) {
            System.out.println(s);
        }

        String podString = "аз";

        List<String> stringAfter = filterPodString(strings, podString);

        System.out.println("\nСтроки после преобразования (где есть \"аз\"):\n");
        for (String s : stringAfter) {
            System.out.println(s);
        }
    }

    public static List<String> filterPodString(List<String> strings, String podString) {
        return strings.stream()
                    .filter(s -> s.contains(podString))
                    .collect(Collectors.toList());
    }
}

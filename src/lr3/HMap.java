package lr3;

// import java.util.Map;
import java.util.HashMap;
import java.util.Map;

public class HMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "Михаил");
        map.put(1, "София");
        map.put(2, "Александр");
        map.put(3, "Анна");
        map.put(4, "Артём");
        map.put(5, "Мария");
        map.put(6, "Матвей");
        map.put(7, "Ольга");
        map.put(8, "Иван");
        map.put(9, "Полина");

        System.out.println("Исходный HashMap: " + map);
        processMap(map);
    }

    public static void processMap(Map<Integer, String> map) {
        // Ключи > 5
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        // 2. Ключ = 0
        String valueAtZero = map.getOrDefault(0, "");
        if (!valueAtZero.isEmpty()) {
            System.out.println("Значение ключа 0: " + valueAtZero);
        }

        // 3. Перемножим ключи, где длина строки > 5
        int product = 1;
        boolean hasElements = false;
        
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                int key = entry.getKey();
                product = product * key;
                hasElements = true;
            }
        }
        
        if (hasElements) {
            System.out.println("Результат перемножения ключей: " + product);
        } else {
            System.out.println("Нет ключей с длиной строки > 5");
        }

    }
}

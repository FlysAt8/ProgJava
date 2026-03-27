package lr3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
    public static long testArrayList(int N) {

        List<Integer> circle = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        long time = System.currentTimeMillis();

        int index = 0;

        while (circle.size() > 1) {
            index = (index+1) % circle.size();
            circle.remove(index);
        }

        time = System.currentTimeMillis() - time;
        return time;
    }

    public static long testLinkedList(int N) {

        List<Integer> circle = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        long time = System.currentTimeMillis();

        int index = 0;

        while (circle.size() > 1) {
            index = (index+1) % circle.size();
            circle.remove(index);
        }

        time = System.currentTimeMillis() - time;
        return time;
    }

    public static long testLinkedListOpt(int N) {

        List<Integer> circle = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        long time = System.currentTimeMillis();

        ListIterator<Integer> iterator = circle.listIterator();

        while (circle.size() > 1) {
            // Продвигаемся на 1 шаг (каждый второй)
            if (!iterator.hasNext()) {
                iterator = circle.listIterator(); // возвращаемся в начало
            }
            iterator.next();

            // Еще один шаг до удаляемого
            if (!iterator.hasNext()) {
                iterator = circle.listIterator();
            }
            iterator.next();
            
            // Удаляем текущий элемент
            iterator.remove();
        }

        time = System.currentTimeMillis() - time;
        return time;
    }

    public static void main(String[] args) {
        int N = 100000;
        System.out.println("Тестирование ArrayList: "+testArrayList(N)+" мс");
        System.out.println("Тестирование LinkedList: "+testLinkedList(N)+" мс");
        System.out.println("Тестирование LinkedList(другой способ): "+testLinkedListOpt(N)+" мс");
    }
}


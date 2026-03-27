package lr3;

import java.util.Scanner;

public class LineList {
    Scanner in = new Scanner(System.in);
    
    public static Node createHead(Scanner in){
        
        int x = in.nextInt();
        if (x == 0){
            System.out.println("Нужен хотябы 1 элемент");
            return null;
        }

        Node node = new Node(x, null);
        Node buf;
        Node head = node;
        while (x != 0){
            x = in.nextInt();
            if (x == 0) break;
            buf = new Node(x, null);
            node.next = buf;
            node = buf;
        }

        return head;
    }

    public static Node createTail(Scanner in){

        int x;
        Node head = null;

        while (true) {
            x = in.nextInt();
            if (x == 0) break;
            head = new Node(x, head);
        }

        return head;
    }

    public static String toString(Node head){
        String str = "";
        if (head == null) {
            str = "Список пуст";
        }
        else {
            str = "Cписок: ";
        }
        while (head != null) {
            str += head.value+" ";
            head = head.next;
        }
        return str;
    }

    public static Node AddFirst(Node head, int value){
        Node first = new Node(value, head);
        return first;
    }

    public static void AddLast(Node head, int value){
        while (head.next != null) {
            head = head.next;
        }
        Node last = new Node(value, null);
        head.next = last;
    }

    public static void Insert(Node head, int value, int index){
        if (index == 0) System.out.println("Для вставки элемента вначале используйте другой метод");
        int i = 0;
        while (i != index-1){
            if (head.next == null){
                System.out.println("Нет стольких элементов");
                return;
            }
            head = head.next;
            i++;
        }
        Node newNode = new Node(value, head.next);
        head.next = newNode;
    }

    public static Node RemoveFirst(Node head){
        if (head == null){
            System.out.println("Список пуст");
        } else if (head.next == null){
            head = null;
        }

        head = head.next;
        
        return head;
    }

    public static void RemoveLast(Node head){
        if (head == null){
            System.out.println("Список пуст");
        } else if (head.next == null){
            head = null;
        }

        while (head.next.next != null) head = head.next;
        
        head.next = null;
    }

    public static void Remove(Node head, int index){
        if (index == 0) System.out.println("Для удаления элемента вначале используйте другой метод");
        int i = 0;
        while (i != index-1){
            if (head.next == null){
                System.out.println("Нет стольких элементов");
                return;
            }
            head = head.next;
            i++;
        }
        if (head.next.next == null) { 
            head.next = null;
        } else{
            head.next = head.next.next;
        }
    }

    // С рекурсией
    public static Node createHeadRec(Scanner in){
        Node head = null;
        int x = in.nextInt();
        if (x != 0){
            head = new Node(x, createHeadRec(in));
        }
        return head;
    }

    public static Node createTailRec(Scanner in, Node tail){
        int x = in.nextInt();
        if (x == 0) return tail;
        
        Node newNode = new Node(x, tail);
        return createTailRec(in, newNode);
    }

    public static String toStringRec(Node head){
        String str = "";
        if (head == null) {
            str = "Список пуст";
        }
        if (head.next != null){
            str = head.value + " " + toStringRec(head.next);
        } else {
            return String.valueOf(head.value);
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Список с головы
        System.out.println("Создание с головы (0 - для завершения)");
        Node head = createHead(in);
        System.out.println(toString(head));
        System.out.println("----------------------------------------");

        // Список с хвоста
        System.out.println("Создание с хвоста (0 - для завершения)");
        head = createTail(in);
        System.out.println(toString(head));
        System.out.println("----------------------------------------");
        
        // Добавление элемента в начале списка
        System.out.print("Добавление элемента в начале списка: ");
        int elem = in.nextInt();
        head = AddFirst(head, elem);
        System.out.println(toString(head));
        System.out.println("----------------------------------------");

        // Добавление элемента в конце списка
        System.out.print("Добавление элемента в конце списка: ");
        elem = in.nextInt();
        AddLast(head, elem);
        System.out.println(toString(head));
        System.out.println("----------------------------------------");

        // Добавление элемента по номеру
        System.out.println("Добавление элемента по номеру в списке: ");
        System.out.print("Элемент: ");
        elem = in.nextInt();
        System.out.print("Номер: ");
        int num = in.nextInt();
        Insert(head, elem, num);
        System.out.println(toString(head));
        System.out.println("----------------------------------------");

        // Удаление первого элемента
        System.out.println("Удаление первого элемента");
        head = RemoveFirst(head);
        System.out.println(toString(head));
        System.out.println("----------------------------------------");

        // Удаление последнего элемента
        System.out.println("Удаление последнего элемента");
        RemoveLast(head);
        System.out.println(toString(head));
        System.out.println("----------------------------------------");

        // Удаление элемента по номеру
        System.out.print("Удаление элемента по номеру в списке: ");
        num = in.nextInt();
        Remove(head, num);
        System.out.println(toString(head));
        System.out.println("----------------------------------------");

        // Список с головы рекурсия
        System.out.println("Создание с головы (рекурсия)");
        head = createHeadRec(in);
        System.out.println(toStringRec(head));
        System.out.println("----------------------------------------");

        // Список с хвоста рекурсия
        System.out.println("Создание с хвоста (рекурсия)");
        head = createTailRec(in, null);
        System.out.println(toStringRec(head));

        in.close();
    }
}

class Node {
    public int value;
    public Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

package lr3.primer2;

public class Test {
    public static void main(String[] args) {
        System.out.println("С головы");
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node ref = node0;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
        System.out.println();

        System.out.println("С хвоста");
        Node head = null;
        for (int i = 0; i < 4; i++) {
            head = new Node(i, head);
        }

        ref = head;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }

    }
}

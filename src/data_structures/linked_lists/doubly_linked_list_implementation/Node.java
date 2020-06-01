package data_structures.linked_lists.doubly_linked_list_implementation;

public class Node {
    int value;
    Node next;
    Node previous;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}

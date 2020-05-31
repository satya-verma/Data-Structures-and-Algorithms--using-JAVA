package data_structures.linked_lists.linked_list_implementation;

import java.util.Arrays;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public int getLength() {
        return length;
    }

    public int[] printList() {
        int[] myList = new int[length];
        Node current = this.head;
        int i = 0;
        while (current != null) {
            myList[i] = current.value;
            current = current.next;
            i++;
        }
        return myList;
    }

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(10);
        myLinkedList.append(12);
        myLinkedList.append(16);
        myLinkedList.prepend(20);
        myLinkedList.prepend(50);
        System.out.println(myLinkedList.getLength());
        System.out.println(Arrays.toString(myLinkedList.printList()));
    }
}

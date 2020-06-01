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

    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            length++;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            head = this.head.next;
            length--;
        } else {
            Node current = head;
            int i;
            for (i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
            if (i == length - 1) {
                tail = current;
            }
        }
    }

    public LinkedList reverse(LinkedList linkedList) {
        LinkedList newList = new LinkedList(linkedList.head.value);
        Node current = linkedList.head;
        while (current.next != null) {
            current = current.next;
            Node newNode = new Node(current.value);
            newNode.next = newList.head;
            newList.head = newNode;
            newList.length++;
        }
        return newList;
    }


    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(10);
        //append
        myLinkedList.append(12);
        myLinkedList.append(16);
        //prepend
        myLinkedList.prepend(20);
        myLinkedList.prepend(50);
        System.out.println("length: " + myLinkedList.getLength());
        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //insert
        myLinkedList.insert(2, 25);
        System.out.println("length: " + myLinkedList.getLength());
        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //remove
        myLinkedList.remove(4);
        System.out.println("length: " + myLinkedList.getLength());
        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //reverse
        LinkedList linkedList2 = myLinkedList.reverse(myLinkedList);
        System.out.println("reverse linkedList" + Arrays.toString(linkedList2.printList()));
    }
}

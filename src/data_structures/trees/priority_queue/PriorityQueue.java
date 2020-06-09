package data_structures.trees.priority_queue;

import java.util.ArrayList;
import java.util.Arrays;

public class PriorityQueue {
    private final ArrayList<Node> queueArray = new ArrayList<>();

    // Note: the smaller number means the higher priority
    public void enqueue(String value, int priority) {
        Node newNode = new Node(value, priority);
        boolean contain = false;

        for (int i = 0; i < queueArray.size(); i++) {
            if (queueArray.get(i).priority > newNode.priority) {
                queueArray.add(i, newNode);
                contain = true;
                break;
            }
        }
        if (!contain) {  // this simply means if(contain == false)
            queueArray.add(newNode);
        }
    }

    public String dequeue() {
        if (queueArray.isEmpty()) {
            return "empty array";
        }
        Node toRemove = queueArray.get(0);
        queueArray.remove(0);
        return toRemove.value;
    }

    public Node front() {
        if (!queueArray.isEmpty()) {
            return queueArray.get(0);
        }
        return null;
    }

    public Node rear() {
        if (!queueArray.isEmpty()) {
            return queueArray.get(queueArray.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return queueArray.isEmpty();
    }

    public String[] printQueue() {
        String[] array = new String[queueArray.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = queueArray.get(i).value;
        }
        return array;
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue("piyush", 3);
        queue.enqueue("rohan", 1);
        queue.enqueue("jeet", 2);
        queue.enqueue("john", 5);
        queue.enqueue("Dave", 4);
        System.out.println(Arrays.toString(queue.printQueue()));
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.printQueue()));
        System.out.println(queue.front().value);
        System.out.println(queue.rear().value);
        System.out.println(queue.isEmpty());
    }
}

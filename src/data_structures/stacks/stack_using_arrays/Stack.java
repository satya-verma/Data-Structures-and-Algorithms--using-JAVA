package data_structures.stacks.stack_using_arrays;

import java.util.ArrayList;

public class Stack {
    ArrayList<String> stackArray;

    public Stack() {
        this.stackArray = new ArrayList<>();
    }

    public String peek() {
        if (this.stackArray.size() > 0) {
            return stackArray.get(stackArray.size() - 1);
        } else {
            return null;
        }
    }

    public void push(String value) {
        this.stackArray.add(value);
    }

    public void pop() {
        this.stackArray.remove(stackArray.size() - 1);
    }

    public boolean isEmpty() {
        return stackArray.size() == 0;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");
        myStack.push("Discord");
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
    }
}

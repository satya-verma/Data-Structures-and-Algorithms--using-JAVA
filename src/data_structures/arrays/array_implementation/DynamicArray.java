package data_structures.arrays.array_implementation;

/* Implementation of our own Dynamic Array Data Structure */

import java.util.Arrays;

class DynamicArray {
    // we will store our elements in the array
    private String[] array;

    // capacity is the number of elements that our array can hold.
    private int capacity;

    // currentLength is the number of elements currently present in the array.
    private int currentLength;

    public DynamicArray() {
        array = new String[1];
        capacity = 1;
        currentLength = 0;
    }

    // get(index) method returns the element of array at the given index.
    public String get(int index) {
        if (index > -1 && index < currentLength)
            return this.array[index];
        else return "Index Out Of Bound";
    }

    // push() method adds an element at the end
    public void push(String string) {
        // if currentLength becomes equal to capacity we need to increase the capacity to add more elements.
        if (currentLength == capacity) {
            // create a new Array with double capacity
            String[] tempArray = new String[2 * capacity];
            // copy elements of old array to new array.
            for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            // set the newly created array as our real array.
            array = tempArray;
            // update the value of capacity
            capacity *= 2;
        }
        // insert the new element at the end
        array[currentLength] = string;
        // update value of currentLength by 1
        currentLength++;
    }

    // replace(index,value) replaces value at given index with the newly entered value.
    public void replace(int index, String value) {
        if (index > -1 && index < currentLength) {
            array[index] = value;
        } else
            System.err.println("Index out of bounds");
    }

    // remove last element
    public void pop() {
        if (currentLength > 0) {
            currentLength--;
        }
    }

    // delete element at the given index
    public void delete(int index) {
        if (index > -1 && index < currentLength) {
            if (index == currentLength - 1) {
                pop();
            } else {
                for (int i = index; i < currentLength; i++) {
                    array[i] = array[i + 1];
                }
                currentLength--;
            }
        } else {
            System.err.println("Index out of bounds");
        }
    }

    // get array
    public String[] getArray() {
        String[] tempArr = new String[currentLength];
        for (int i = 0; i < currentLength; i++) {
            tempArr[i] = array[i];
        }
        return tempArr;
    }

    // returns the length of array{Number of elements stored in the array}
    public int length() {
        return currentLength;
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.push("apple");
        dynamicArray.push("ball");
        dynamicArray.push("cat");
        dynamicArray.push("dog");
        System.out.println("Array-Length: " + dynamicArray.length());
        System.out.println("array: " + Arrays.toString(dynamicArray.getArray()));
        System.out.println("item at index 2: " + dynamicArray.get(2));
        dynamicArray.replace(1, "world");
        System.out.println("array: " + Arrays.toString(dynamicArray.getArray()));
        dynamicArray.pop();
        System.out.println("array: " + Arrays.toString(dynamicArray.getArray()));
        dynamicArray.delete(1);
        System.out.println("array: " + Arrays.toString(dynamicArray.getArray()));
        System.out.println("Array-Length: " + dynamicArray.length());
    }
}
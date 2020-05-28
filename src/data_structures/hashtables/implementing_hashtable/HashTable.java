package data_structures.hashtables.implementing_hashtable;

/*
Note: This code can be Optimized with all types of safety but for sake of understanding
      its been kept simple.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {
    // create an array that will hold elements of type ArrayList<KeyValue>.
    // ArrayList<keyValue> means the ArrayList holds Objects of type - keyValue as its elements.
    ArrayList<KeyValue>[] data;
    int currentLength;

    public HashTable(int size) {
        data = new ArrayList[size];
        currentLength = 0;
    }

    private int _hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.codePointAt(i) * i) % data.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int address = _hash(key);
        if (data[address] == null) {
            ArrayList<KeyValue> arrayAtAddress = new ArrayList<>();
            data[address] = arrayAtAddress;
            currentLength++;
        }
        KeyValue pair = new KeyValue(key, value);
        data[address].add(pair);
    }

    public Integer get(String key) {
        int address = _hash(key);
        ArrayList<KeyValue> bucket = data[address];
        if (bucket != null) {
            for (KeyValue keyValue : bucket) {
                if (keyValue.getKey().equals(key)) {
                    return keyValue.getValue();
                }
            }
        }
        return null; // return null when key does not exist.
    }

    public String[] keys() {
        ArrayList<KeyValue>[] bucket = data;
        String[] keysArray = new String[currentLength];
        int count = 0;
        for (ArrayList<KeyValue> keyValues : bucket) {
            if (keyValues != null) {
                keysArray[count] = keyValues.get(0).getKey();
                count++;
            }
        }
        return keysArray;
    }


    public static void main(String[] args) {
        HashTable hashTable = new HashTable(50);
        hashTable.set("grapes", 1200);
        hashTable.set("apple", 1500);
        System.out.println("value for key grapes: " + hashTable.get("grapes"));
        System.out.println("value for key apple: " + hashTable.get("apple"));
        System.out.println("list of keys: " + Arrays.toString(hashTable.keys()));
    }
}

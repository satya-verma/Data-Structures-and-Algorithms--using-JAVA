package data_structures.trees.binary_search_tree;

import java.util.ArrayList;

public class HelperFunctions {
    // traverse in order
    public ArrayList<Integer> traverseInOrder(Node node, ArrayList<Integer> array) {
        if (node.left != null) {
            traverseInOrder(node.left, array);
        }
        array.add(node.value);
        if (node.right != null) {
            traverseInOrder(node.right, array);
        }
        return array;
    }

    // traverse pre order
    public ArrayList<Integer> traversePreOrder(Node node, ArrayList<Integer> array) {
        array.add(node.value);
        if (node.left != null) {
            traversePreOrder(node.left, array);
        }
        if (node.right != null) {
            traversePreOrder(node.right, array);
        }
        return array;
    }

    // traverse post order
    public ArrayList<Integer> traversePostOrder(Node node, ArrayList<Integer> array) {
        if (node.left != null) {
            traversePostOrder(node.left, array);
        }
        if (node.right != null) {
            traversePostOrder(node.right, array);
        }
        array.add(node.value);
        return array;
    }

}

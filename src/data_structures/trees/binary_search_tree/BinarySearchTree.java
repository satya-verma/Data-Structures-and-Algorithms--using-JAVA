package data_structures.trees.binary_search_tree;

import java.util.ArrayList;

public class BinarySearchTree {
    Node root = null;

    ///////////////////////////////////////////////////////
    //////////          insert function       /////////////
    ///////////////////////////////////////////////////////
    public void insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node current = this.root;
            while (true) {
                // right
                if (current.value < value) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                    // left
                } else {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                }
            }
        }
    }

    ///////////////////////////////////////////////////////
    //////////          lookup function       /////////////
    ///////////////////////////////////////////////////////
    public boolean lookup(int value) {
        Node current = this.root;
        while (current != null) {
            if (current.value > value) {
                current = current.left;
            } else if (current.value < value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    ///////////////////////////////////////////////////////
    //////////          remove function       /////////////
    ///////////////////////////////////////////////////////
    public void remove(int value) {
        if (this.root == null) {
            return;
        }
        Node current = this.root;
        Node parentNode = null;
        // while current is not null
        while (current != null) {
            if (value < current.value) {
                // go left
                parentNode = current;
                current = current.left;
            } else if (value > current.value) {
                // go right
                parentNode = current;
                current = current.right;
            }
            // (value == current.value, means if we found the value to be removed)
            else {
                // Option 1: NO RIGHT CHILD            // Child means the child of current Node
                if (current.right == null) {
                    // if parentNode is null means delete the root node
                    if (parentNode == null) {
                        this.root = current.left;
                    } else {
                        // if current < parent, make current left child a left child of parent
                        if (current.value < parentNode.value) {
                            parentNode.left = current.left;

                        }
                        // if current > parent, make current's left child a right child of parent
                        else if (current.value > parentNode.value) {
                            parentNode.right = current.left;
                        }
                    }
                }

                // Option 2: RIGHT CHILD WHICH DOESN'T HAVE A LEFT CHILD
                else if (current.right.left == null) {
                    if (parentNode == null) {
                        this.root = current.right;
                    } else {
                        // if current < parent, make current's right child a left child of parent
                        if (current.value < parentNode.value) {
                            parentNode.left = current.right;
                        }
                        // if current > parent, make current's right child a right child of parent
                        else if (current.value > parentNode.value) {
                            parentNode.right = current.right;
                        }
                    }
                }

                // Option 3: RIGHT CHILD WHICH HAVE LEFT CHILD
                else {
                    if (parentNode == null) {
                        // save reference of left and right nodes of the root
                        Node leftNode = this.root.left;
                        Node rightNode = this.root.right;
                        // root.right.left node becomes new root
                        this.root = current.right.left;
                        rightNode.left = rightNode.left.right;
                        // set back the saved reference of left and right nodes of root.
                        this.root.left = leftNode;
                        this.root.right = rightNode;
                    } else {
                        if (current.value < parentNode.value) {
                            parentNode.left = current.right.left;
                        } else if (current.value > parentNode.value) {
                            parentNode.right = current.right.left;
                        }
                    }
                }
                return;
            }
        }
    }

    ///////////////////////////////////////////////////////
    //                breadth first search               //
    //   note: {this method is from algorithms section-  //
    // skip this if you are in Data Structures section}  //
    ///////////////////////////////////////////////////////
    public ArrayList<Integer> breadFirstSearch() {
        Node currentNode = this.root;
        ArrayList<Integer> resultArray = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove(0);
            resultArray.add(currentNode.value);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return resultArray;
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        System.out.println(bst.breadFirstSearch());
        System.out.println(bst.lookup(20));
        bst.remove(20);
        System.out.println(bst.lookup(20));
    }
}

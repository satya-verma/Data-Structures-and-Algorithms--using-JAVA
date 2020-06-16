package data_structures.graphs;


import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {
    int numberOfNodes = 0;
    Hashtable<Integer, ArrayList<Integer>> adjacentList = new Hashtable<>();

    public void addVertex(int node) {
        adjacentList.put(node, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge(int node1, int node2) {
        adjacentList.get(node1).add(node2);
        adjacentList.get(node2).add(node1);
    }

    public void showConnections() {
        Object[] keys = adjacentList.keySet().toArray();
        for (Object key : keys) {
            System.out.println(key + " ---> " + adjacentList.get(Integer.parseInt(key.toString())));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(5);
        graph.addVertex(54);
        graph.addVertex(44);
        graph.addEdge(5,54);
        graph.addEdge(5,44);
        graph.showConnections();
    }
}



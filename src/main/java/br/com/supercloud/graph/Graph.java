package br.com.supercloud.graph;

import java.util.*;

public class Graph {
    static class Node {
        int id;
        List<Node> adjacent = new LinkedList<>();

        public Node(int id) {
            this.id = id;
        }
    }

    Map<Integer, Node> nodeLookup = new HashMap<>();

    Node getNode(int id) {
        Node node = nodeLookup.get(id);
        if (node == null) {
            node = new Node(id);
            nodeLookup.put(id, node);
        }
        return node;
    }

    void addEdge(int src, int dst) {
        Node s = getNode(src);
        Node d = getNode(dst);
        s.adjacent.add(d);
    }
}

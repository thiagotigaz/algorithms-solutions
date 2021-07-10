package br.com.supercloud.graph;

import java.util.HashSet;
import java.util.Set;

public class BreadthFirstSearch {
    Graph graph;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    boolean hasPath(int src, int dst) {
        Graph.Node s = graph.getNode(src);
        Graph.Node d = graph.getNode(dst);
        Set<Integer> visited = new HashSet<>();
        return hasPath(s, d, visited);
    }

    private boolean hasPath(Graph.Node src, Graph.Node dst, Set<Integer> visited) {
        if (visited.contains(src)) {
            return false;
        }
        if (src == dst) {
            return true;
        }
        visited.add(src.id);
        for (Graph.Node child : src.adjacent) {
            if (hasPath(child, dst, visited))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
        graph.getNode(1);
        graph.getNode(2);
        graph.getNode(3);
        graph.getNode(4);
        graph.getNode(5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        System.out.println(breadthFirstSearch.hasPath(1, 5));
    }
}

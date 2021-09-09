package br.com.supercloud.graph;

import java.util.HashSet;

public class DeepthFirstSearch {

    Graph graph;

    public DeepthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    /*boolean hasPath(int src, int dst) {
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
    }*/

    public static void main(String[] args) {
        Graph graph = new Graph();
        DeepthFirstSearch breadthFirstSearch = new DeepthFirstSearch(graph);
        graph.getNode(1);
        graph.getNode(2);
        graph.getNode(3);
        graph.getNode(4);
        graph.getNode(5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 6);
        System.out.println(breadthFirstSearch.hasPath(1, 6));
    }

    private boolean hasPath(int id, int id2) {
        Graph.Node src = graph.getNode(id);
        Graph.Node dst = graph.getNode(id2);
        return hasPath(src, dst, new HashSet<Integer>());
    }

    private boolean hasPath(Graph.Node src, Graph.Node dst, HashSet<Integer> visited) {
        if (visited.contains(src.id)) return false;
        if (src == dst) return true;
        visited.add(src.id);
        for (Graph.Node node : src.adjacent) {
            if (hasPath(node, dst, visited)) {
                return true;
            }
        }
        return false;
    }

}

package br.com.supercloud.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

    Graph graph;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    /*boolean hasPath(int src, int dest) {
        return hasPath(graph.getNode(src), graph.getNode(dest));
    }

    private boolean hasPath(Graph.Node src, Graph.Node dst) {
        Set<Integer> visited = new HashSet<>();
        Queue<Graph.Node> nextToVisit = new LinkedList<>();
        nextToVisit.add(src);
        int loopCount = 0;
        while (!nextToVisit.isEmpty()) {
            loopCount++;
            Graph.Node n = nextToVisit.remove();
            if (n == dst) {
                return true;
            }
            if (!visited.contains(n.id)) {
                visited.add(n.id);
                nextToVisit.addAll(n.adjacent);
            }
        }
        return false;
    }*/

    public static void main(String[] args) {
        Graph graph = new Graph();
        BreadthFirstSearch deepthFirstSearch = new BreadthFirstSearch(graph);
        graph.getNode(1);
        graph.getNode(2);
        graph.getNode(3);
        graph.getNode(4);
        graph.getNode(5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        System.out.println(deepthFirstSearch.hasPath(1, 5));
    }

    private boolean hasPath(int id, int id2) {
        Graph.Node src = graph.getNode(id);
        Graph.Node dst = graph.getNode(id2);
        Set<Graph.Node> visited = new HashSet<>();
        Queue<Graph.Node> nextToVisit = new LinkedList<>();
        nextToVisit.add(src);
        while (!nextToVisit.isEmpty()) {
            Graph.Node node = nextToVisit.remove();
            if (node == dst) return true;
            visited.add(node);
            for (Graph.Node child : node.adjacent) {
                if (!visited.contains(child)) {
                    nextToVisit.add(child);
                }
            }
        }
        return false;
    }


}

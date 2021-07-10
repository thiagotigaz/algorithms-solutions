package br.com.supercloud.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class WalkablePathBFS {

    private static final int WALKABLE_PATH_VALUE = 1;
    private static final int DESTINATION_PATH_VALUE = 9;
    private static final int[] ROW_NUM = {-1, 0, 0, 1}; // Used to check for neighbors
    private static final int[] COL_NUM = {0, -1, 1, 0}; // Used to check for neighbors
    private static final int[][] MATRIX = {
            {1, 1, 1, 1},
            {0, 1, 1, 0},
            {0, 1, 0, 1},
            {0, 1, 9, 1},
            {1, 1, 1, 1}
    };
    private final Queue<Node> queue = new LinkedList<>();

    static class Coordinate {

        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" + "x=" + x + ", y=" + y + '}';
        }


    }

    class Node {

        Node previousNode;
        Coordinate coordinate;
        int dist;

        Node(Node previousNode, Coordinate coordinate, int dist) {
            this.previousNode = previousNode;
            this.coordinate = coordinate;
            this.dist = dist;
        }

    }

    // The speed complexity is O(k pow q), k being the number of nodes and q being the path distance
    private Node doSearch(int[][] matrix, Coordinate src, Coordinate dst) {
        if (matrix[src.x][src.y] != WALKABLE_PATH_VALUE || matrix[dst.x][dst.y] != DESTINATION_PATH_VALUE) {
            throw new RuntimeException("Source and destination should be valid routes (1)");
        }
        int n = matrix.length; // rows count
        int m = matrix[0].length; // columns count
        boolean[][] visited = new boolean[n][m];

        visited[src.x][src.y] = true; // mark source as visited;
        Node srcNode = new Node(null, src, 0); // Distance from source node is 0
        queue.add(srcNode);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            Coordinate c = node.coordinate;
            // If we have found the destination coordinate, we just return the node that contains the distance inside
            if (c.x == dst.x && c.y == dst.y) {
                return node;
            }

            for (int i = 0; i < 4; i++) {
                int row = c.x + ROW_NUM[i];
                int col = c.y + COL_NUM[i];
                Coordinate coordinate = new Coordinate(row, col);
                // if neighbor cell is valid, has path and is not visited yet, then enqueue it
                if (isValidCell(matrix, row, col)
                        && (matrix[row][col] == WALKABLE_PATH_VALUE || matrix[row][col] == DESTINATION_PATH_VALUE)
                        && !visited[row][col]) {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    Node adjNode = new Node(node, coordinate, node.dist + 1);
                    queue.add(adjNode);
                }
            }
        }
        throw new RuntimeException(
                String.format("There is no path between source: {%d, %d} and destination: {%d, %d}",
                        src.x, src.y, dst.x, dst.y));
    }

    private boolean isValidCell(int[][] matrix, int row, int col) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[0].length);
    }

    public static void main(String[] args) {
        WalkablePathBFS bfs = new WalkablePathBFS();
        Coordinate src = new Coordinate(0, 0); // top left corner
        Coordinate dst = new Coordinate(3, 2); // 9
        Node node = bfs.doSearch(MATRIX, src, dst);
        System.out.println(String.format(
                "The number os steps between source: {%d, %d} and destination: {%d, %d} is %d",
                src.x, src.y, node.coordinate.x, node.coordinate.y, node.dist
        ));

        // Traverse the tree back from destination to source adding in a stack to revert it for printing the route
        // in the right order
        Stack<Coordinate> route = new Stack<>();
        while (node != null) {
            route.push(node.coordinate);
            node = node.previousNode;
        }
        while (!route.isEmpty()) {
            System.out.println(route.pop());
        }
    }

}

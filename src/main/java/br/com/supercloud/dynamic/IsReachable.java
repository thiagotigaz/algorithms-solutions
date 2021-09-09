package br.com.supercloud.dynamic;

import java.util.*;

public class IsReachable {

    /*

        Given a board and an end position for the player, write a function to determine if it is possible to travel from every open cell on the board to the given end position.

        board1 = [
            [ 0,  0,  0, 0, -1 ],
            [ 0, -1, -1, 0,  0 ],
            [ 0,  0,  0, 0,  0 ],
            [ 0, -1,  0, 0,  0 ],
            [ 0,  0,  0, 0,  0 ],
            [ 0,  0,  0, 0,  0 ],
        ]

        board2 = [
            [  0,  0,  0, 0, -1 ],
            [  0, -1, -1, 0,  0 ],
            [  0,  0,  0, 0,  0 ],
            [ -1, -1,  0, 0,  0 ],
            [  0, -1,  0, 0,  0 ],
            [  0, -1,  0, 0,  0 ],
        ]

        board3 = [
            [ 0,  0,  0,  0,  0,  0, 0 ],
            [ 0, -1, -1, -1, -1, -1, 0 ],
            [ 0, -1,  0,  0,  0, -1, 0 ],
            [ 0, -1,  0,  0,  0, -1, 0 ],
            [ 0, -1,  0,  0,  0, -1, 0 ],
            [ 0, -1, -1, -1, -1, -1, 0 ],
            [ 0,  0,  0,  0,  0,  0, 0 ],
        ]

        board4 = [
            [0,  0,  0,  0, 0],
            [0, -1, -1, -1, 0],
            [0, -1, -1, -1, 0],
            [0, -1, -1, -1, 0],
            [0,  0,  0,  0, 0],
        ]

        board5 = [
            [0],
        ]

        end1 = (0, 0)
        end2 = (5, 0)

        Expected output:

        isReachable(board1, end1) -> True
        isReachable(board1, end2) -> True
        isReachable(board2, end1) -> False
        isReachable(board2, end2) -> False
        isReachable(board3, end1) -> False
        isReachable(board4, end1) -> True
        isReachable(board5, end1) -> True

        n: width of the input board
        m: height of the input board

    */

    public static List<List<Integer>> getPossibleMoves(int[][] map, int[] userPosition) {
        List<List<Integer>> result = new ArrayList<>();
        // left, up, right, down
        int x = userPosition[0];
        int y = userPosition[1];
        // left move
        if (y > 0 && map[x][y - 1] == 0) {
            result.add(Arrays.asList(x, y - 1));
        }

        // up move
        if (x > 0 && map[x - 1][y] == 0) {
            result.add(Arrays.asList(x - 1, y));
        }

        // right move
        if (y < map[0].length - 1 && map[x][y + 1] == 0) {
            result.add(Arrays.asList(x, y + 1));
        }

        // down move
        if (x < map.length - 1 && map[x + 1][y] == 0) {
            result.add(Arrays.asList(x + 1, y));
        }

        return result;
    }



    /*public static boolean isReachable(int[][] map, int[] endPosition, Set<String> memo) {
        // left, up, right, down
        int x = endPosition[0];
        int y = endPosition[1];


        // left move
        if (y > 0 && map[x][y - 1] == 0) {
            memo.add(x + "," + (y - 1));
            isReachable()
        }

        // up move
        if (x > 0 && map[x - 1][y] == 0) {
            memo.add(x - 1 + "," + y);
            isReachable()
        }

        // right move
        if (y < map[0].length - 1 && map[x][y + 1] == 0) {
            memo.add(x + "," + (y + 1));
            isReachable()
        }

        // down move
        if (x < map.length - 1 && map[x + 1][y] == 0) {
            memo.add((x + 1) + "," + 1);
            isReachable()
        }

        for {
            for {

            }
        }

        return walkable && isRea;
    }*/

    static int[][] DIRECTIONS = new int[][]{
            {0, -1}, // left
            {-1, 0}, // up
            {0, 1},  // right
            {1, 0}  // down
    };

    //[1,2],[2,4]
    public static boolean isReachable(int[][] map, int[] endPosition, Map<String, Integer> memo) {
        int row = endPosition[0];
        int col = endPosition[1];
//        String pos = row + "," + col;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(endPosition);
        while (!queue.isEmpty()) {
            int[] currentPos = queue.remove();
            visited.add(currentPos[0] + "," + currentPos[1]);
            for (int[] direction : DIRECTIONS) {
                int nRow = currentPos[0] + direction[0];
                int nCol = currentPos[1] + direction[1];
                if (nRow >= 0 && nRow < map.length && nCol >= 0 && nCol < map[0].length) {
                    if (map[nRow][nCol] == 0 && !visited.contains(nRow + "," + nCol)) {
                        queue.add(new int[]{nRow, nCol});
                    }
                }
            }
        }

//        visited.forEach(System.out::println);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 && !visited.contains(i + "," + j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] argv) {
        int[][] board1 = new int[][]{
                {0, 0, 0, 0, -1},
                {0, -1, -1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, -1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };

        int[][] board2 = new int[][]{
                {0, 0, 0, 0, -1},
                {0, -1, -1, 0, 0},
                {0, 0, 0, 0, 0},
                {-1, -1, 0, 0, 0},
                {0, -1, 0, 0, 0},
                {0, -1, 0, 0, 0},
        };

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, -1, -1, -1, -1, -1, 0},
                {0, -1, 0, 0, 0, -1, 0},
                {0, -1, 0, 0, 0, -1, 0},
                {0, -1, 0, 0, 0, -1, 0},
                {0, -1, -1, -1, -1, -1, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };

        int[][] board4 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, -1, -1, -1, 0},
                {0, -1, -1, -1, 0},
                {0, -1, -1, -1, 0},
                {0, 0, 0, 0, 0},
        };

        int[][] board5 = new int[][]{
                {0},
        };

        int[] end1 = new int[]{0, 0};
        int[] end2 = new int[]{5, 0};
        int[] end3 = new int[]{3, 3};
        int[] end4 = new int[]{4, 0};

//        System.out.println(isReachable(board1, end1, new HashMap<>()));
//        System.out.println(isReachable(board2, end1, new HashMap<>()));
//        System.out.println(isReachable(board3, end1, new HashMap<>()));
//        System.out.println(isReachable(board4, end1, new HashMap<>()));
//        System.out.println(isReachable(board5, end1, new HashMap<>()));
//        System.out.println(isReachable(board1, end2, new HashMap<>()));
//        System.out.println(isReachable(board2, end2, new HashMap<>()));
//        System.out.println(isReachable(board3, end2, new HashMap<>()));
//        System.out.println(isReachable(board4, end2, new HashMap<>()));
//        System.out.println(isReachable(board1, end3, new HashMap<>()));
//        System.out.println(isReachable(board2, end3, new HashMap<>()));
//        System.out.println(isReachable(board3, end3, new HashMap<>()));
//        System.out.println(isReachable(board4, end3, new HashMap<>()));
        System.out.println(isReachable(board4, end4, new HashMap<>()));


//     List<List<Integer>> results = getPossibleMoves(board, start4);
//     for(List<Integer> move:results) {
//       System.out.println(move.get(0) + ", " + move.get(1));
//     }
    }

}

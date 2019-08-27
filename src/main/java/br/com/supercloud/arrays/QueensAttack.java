package br.com.supercloud.arrays;

public class QueensAttack {

    static int queensAttack(int n, int k, int rQueen, int cQueen, int[][] obstacles) {
        if (n <= 1) {
            return 0;
        }
        // Row / Column coordinates of the closest object in each direction
        int rRObstacle = -1; // Row right
        int cRObstacle = -1; // Col Right
        int rBRObstacle = -1; // Row Bottom Right
        int cBRObstacle = -1; // Col Bottom Right
        int rBObstacle = -1; // Row Bottom
        int cBObstacle = -1; // Col Bottom
        int rBLObstacle = -1; // Row Bottom Left
        int cBLObstacle = -1; // Col Bottom left
        int rLObstacle = -1; // Row Left
        int cLObstacle = -1; // Col Left
        int rTLObstacle = -1; // Row Top Left
        int cTLObstacle = -1; // Col Top Left
        int rTObstacle = -1; // Row Top
        int cTObstacle = -1; // Col Top
        int rTRObstacle = -1; // Row Top Right
        int cTRObstacle = -1; // Col Top Right
        // Number of queen's reachable squares
        int reachableSquares = 0;
        for (int i = 0; i < k; i++) {
            int rObstacle = obstacles[i][0]; // Row Obstacle
            int cObstacle = obstacles[i][1]; // Col Obstable

            // Right
            if ((cObstacle < cRObstacle || rRObstacle == -1) && cObstacle > cQueen && rObstacle == rQueen) {
                rRObstacle = rObstacle;
                cRObstacle = cObstacle;
            }

            // Bottom Right
            boolean isDiagonal = rQueen - rObstacle == cObstacle - cQueen;
            if (isDiagonal && cObstacle > cQueen && rObstacle < rQueen
                    && ((cObstacle < cBRObstacle && rObstacle > rBRObstacle) || rBRObstacle == -1)) {
                rBRObstacle = rObstacle;
                cBRObstacle = cObstacle;
            }

            // Bottom
            if ((rObstacle > rBObstacle || rBObstacle == -1) && rObstacle < rQueen && cObstacle == cQueen) {
                rBObstacle = rObstacle;
                cBObstacle = cObstacle;
            }

            // Bottom Left
            isDiagonal = cQueen - cObstacle == rQueen - rObstacle;
            if (isDiagonal && cObstacle < cQueen && rObstacle < rQueen
                    && ((cObstacle > cBLObstacle && rObstacle > rBLObstacle) || rBLObstacle == -1)) {
                rBLObstacle = rObstacle;
                cBLObstacle = cObstacle;
            }

            // Left
            if ((cObstacle > cLObstacle || rLObstacle == -1) && cObstacle < cQueen && rObstacle == rQueen) {
                rLObstacle = rObstacle;
                cLObstacle = cObstacle;
            }

            // Top Left
            isDiagonal = cQueen - cObstacle == rObstacle - rQueen;
            if (isDiagonal && cObstacle < cQueen && rObstacle > rQueen
                    && ((cObstacle > cTLObstacle && rObstacle < rTLObstacle) || rTLObstacle == -1)) {
                rTLObstacle = rObstacle;
                cTLObstacle = cObstacle;
            }

            // Top
            if ((rObstacle < rTObstacle || rTObstacle == -1) && rObstacle > rQueen && cObstacle == cQueen) {
                rTObstacle = rObstacle;
                cTObstacle = cObstacle;
            }

            // Top Right
            isDiagonal = cObstacle - cQueen == rObstacle - rQueen;
            if (isDiagonal && cObstacle > cQueen && rObstacle > rQueen
                    && ((rObstacle < rTRObstacle && cObstacle < cTRObstacle) || rTRObstacle == -1)) {
                rTRObstacle = rObstacle;
                cTRObstacle = cObstacle;
            }
        }

        // Right / Bottom / Left / Top
        reachableSquares += cRObstacle != -1 ? (cRObstacle - cQueen - 1) : n - cQueen;
        reachableSquares += rBObstacle != -1 ? (rQueen - rBObstacle - 1) : rQueen - 1;
        reachableSquares += cLObstacle != -1 ? (cQueen - cLObstacle - 1) : cQueen - 1;
        reachableSquares += rTObstacle != -1 ? (rTObstacle - rQueen - 1) : n - rQueen;

        // Bottom Right / Bottom Left / Top Left / Top Right
        reachableSquares += cBRObstacle != -1 ? (cBRObstacle - cQueen - 1) : Math.min(n - cQueen, rQueen - 1);
        reachableSquares += rBLObstacle != -1 ? (cQueen - cBLObstacle - 1) : Math.min(cQueen - 1, rQueen - 1);
        reachableSquares += cTLObstacle != -1 ? (rTLObstacle - rQueen - 1) : Math.min(cQueen - 1, n - rQueen);
        reachableSquares += rTRObstacle != -1 ? (cTRObstacle - cQueen - 1) : Math.min(n - cQueen, n - rQueen);

        return reachableSquares;
    }


    public static void main(String[] args) {
        int spaces = queensAttack(5, 3, 4, 3, new int[][]{{5, 5}, {4, 2}, {2, 3}});
        System.out.println(spaces);
    }
}

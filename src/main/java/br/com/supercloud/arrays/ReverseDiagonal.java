package br.com.supercloud.arrays;

public class ReverseDiagonal {


    /*
         If the input is

         1 2 3 4
         5 6 7 8
         9 a b c

         output would be to print

         1
         2 5
         3 6 9
         4 7 a
         8 b
         c
     */
    public static void reverseDiagonal(char[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int lines = rows + cols - 1;
        int maxPrint = Math.min(rows, cols);
        for (int i = 0; i < lines; i++) {
            int printCount = Math.min(maxPrint, Math.min(i + 1, lines - i));
            int startCol = Math.min(i, cols - 1);
            for (int j = 0; j < printCount; j++) {
                int x = Math.max(Math.min(rows - 1, j), Math.min(rows - 1, i - startCol + j));
                int y = Math.min(Math.min(startCol - j, cols - 1), startCol);
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1', '2', '3', '4'},
                {'5', '6', '7', '8'},
                {'9', 'a', 'b', 'c'},
                {'d', 'e', 'f', 'g'},
                {'h', 'i', 'j', 'k'},
        };

        reverseDiagonal(arr);
    }

}

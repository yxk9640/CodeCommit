package LeetCodeDaily;/*
 @yxk
*/

public class RestoreMatrix {
    public static void main(String[] args) {
        System.out.println(restoreMatrix(new int[]{3,8}, new int[]{4,7}));
    }
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length, col = colSum.length;
        int[][] restore = new int[row][col];
        int[] curRow = new int[row];
        int[] curCol = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                restore[i][j] = Math.min(rowSum[i]-curRow[i], colSum[j]-curCol[j]);
                curRow[i] -= restore[i][j];
                curCol[j] -= restore[i][j];
            }
        }

        return restore;
    }
}

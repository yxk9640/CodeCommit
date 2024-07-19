package LeetCodeDaily;/*
 @yxk
*/

import java.util.*;

public class LuckyNumbers {
    public static void main(String[] args) {
//        System.out.println(luckyNumbers(new
//                int[][]{{3,7,8},{9,11,13},{15,16,17}}));
        System.out.println(luckyNumbers(new
                int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        List<Integer> minRow = new ArrayList<>();
        List<Integer> maxCol = new ArrayList<>();
//        row
        for (int[] ints : matrix) {
            int min = Integer.MAX_VALUE;
            for (int c = 0; c < matrix[0].length; c++) {
                min = Math.min(min, ints[c]);
            }
            minRow.add(min);
        }
//        col
        for (int c = 0; c < matrix[0].length; c++) {
            int max = 0;
            for (int r = 0; r < matrix.length; r++) {
                max = Math.max(max, matrix[r][c]);
            }
            maxCol.add(max);

        }

//        System.out.println(minRow+", Rows ");
//        System.out.println(maxCol+", Cols ");
        for(int num: minRow){
            if ( maxCol.contains(num)){
                res.add(num);
            }
        }

        return res;
    }
}

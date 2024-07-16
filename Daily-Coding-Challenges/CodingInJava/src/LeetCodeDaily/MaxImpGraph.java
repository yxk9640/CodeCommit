package LeetCodeDaily;

import javax.swing.text.html.BlockView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxImpGraph {
    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][]{{0,3},{2,4},{1,3}}));
    }
    public static long maximumImportance(int n, int[][] roads) {
        long sum = 0;
//        get freq -> count
//        HashMap<Integer, Integer> count = new HashMap<>();
        long[] count = new long[n];

        for (int i = 0; i < roads.length; i++) {
            count[roads[i][0]]++;
            count[roads[i][1]]++;
        }
        Arrays.sort(count);
        System.out.println(Arrays.toString(count));
        long value = 1;
        for (long c: count){
            sum += (value * c);
            value++;
        }

//        assign prioriy to each number

        return sum;
    }
}

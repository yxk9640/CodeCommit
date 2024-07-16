package LeetCodeDaily;

import java.util.*;

public class MaxCapital {
    public static void main(String[] args) {
//        System.out.println(findMaximizedCapital(2,0,
//                new int[]{1,2,3}, new  int[]{0,1,1}));
        System.out.println(findMaximizedCapital(3,0,
                new int[]{1,2,3}, new  int[]{0,1,2}));
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        PriorityQueue<int[]> maxProf = new PriorityQueue<>((a,b)-> b[1] - a[1]);

        for (int i = 0; i < profits.length; i++) {
            minCap.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minCap.isEmpty() && minCap.peek()[0] <= w){
                maxProf.offer(minCap.poll());
            }

            if (maxProf.isEmpty()) break;
            w+= maxProf.poll()[1];
        }
        return  w;

    }


}

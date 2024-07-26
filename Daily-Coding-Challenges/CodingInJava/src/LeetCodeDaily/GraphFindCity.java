package LeetCodeDaily;/*
 @yxk
*/

import java.util.*;

public class GraphFindCity {
    public static void main(String[] args) {
        System.out.println(findTheCity(4, new int[][]
                {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
    }
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<Integer> res = new ArrayList<>();
        int minLen = Integer.MAX_VALUE;
        Map<Integer, int[]> neighbour = new HashMap<>();
        for (int i = 0; i < n; i++) {
            neighbour.put(i, buildNeighbour(i, edges, distanceThreshold));
            int curLen = neighbour.get(i).length;
            if (curLen == minLen){
                res.add(i);
            } else if (curLen < minLen) {
                res.clear();
                res.add(i);
                minLen = curLen;
            }
        }
        // if 2 nodes have same neighbours return max
        int maxNode = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            maxNode = Math.max(maxNode, res.get(i));
        }


        return maxNode;
    }

    public static int[] buildNeighbour(int from, int[][] edges,int maxDist ){
        return new int[]{};
    }
}

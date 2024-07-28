package LeetCodeDaily;/*
 @yxk
*/

import java.util.*;

public class GraphSecondMinimumBFS {
    public static void main(String[] args) {
        System.out.println(secondMinimum(5,
                new int[][]{{1,2},{1,3},{1,4},{3,4},{4,5}}, 3,5));
    }
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        //go level by level - BFS
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges){
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }
        int[] minDist = new int[n + 1], secDist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            minDist[i] = secDist[i] = -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,1});
        minDist[1]=0;


        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int node = temp[0];
            int freq = temp[1];

            int timeTaken = freq == 1 ? minDist[node]:secDist[node];

            // calculate the time
            if ( (timeTaken / change) % 2 == 1){
                //red light
                timeTaken = change * ( timeTaken/change + 1) + time;
            }
            else {
                //green light
                timeTaken = timeTaken + time;
            }

            if (!adj.containsKey(node)) continue;
            for (int neigh : adj.get(node) ){
                if( minDist[neigh] == -1){
                    minDist[neigh] = timeTaken;
                    queue.offer(new int[]{neigh, 1});
                } else if (secDist[neigh] == -1 && minDist[neigh]!= timeTaken) {
                    if (neigh == n) return timeTaken;
                    secDist[neigh] = timeTaken;
                    queue.offer(new int[]{neigh, 2});

                }
            }

        }




        return 0;
    }
}

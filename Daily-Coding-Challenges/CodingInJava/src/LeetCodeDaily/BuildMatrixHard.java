package LeetCodeDaily;/*
 @yxk
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildMatrixHard {
    public static void main(String[] args) {
        System.out.println(buildMatrix(3, new int[][]{{1,2},{3,2}},
                new int[][]{{2,1},{3,2}}));

    }
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions){
        int[][] res = new int[k][k];
        List<Integer> rows = topoSort(rowConditions,k);
        List<Integer> cols = topoSort(colConditions,k);

        if (rows.isEmpty() || cols.isEmpty()) return new int[0][0];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rows.get(i).equals(cols.get(j))){
                    res[i][j] = rows.get(i);
                }
            }
        }
        return res;
    }

    private static List<Integer> topoSort(int[][] edges, int size){
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
        }
        List<Integer> order = new ArrayList<>();
        int[] visited = new int[size+1];
        boolean[] isCycle = {false};
        for (int i = 0; i <= size; i++) {
            if (visited[i] == 0){
                dfs(i, adj, visited, order, isCycle);
                if(isCycle[0]) return new ArrayList<>();
            }
        }
        Collections.reverse(order);
        return order;
    }

    private static void dfs(int node, List<List<Integer>> adj, int[] visit,
                     List<Integer> order, boolean[] isCycle){
        visit[node] = 1;
        for (int neighbor: adj.get(node)){
            if (visit[neighbor] == 0){
                dfs(neighbor, adj, visit, order, isCycle);

                if (isCycle[0]) return;
            }else if(visit[neighbor] == 1){
                isCycle[0] = true;
                return;
            }
        }
        visit[node] = 2;
        order.add(node);

    }
}

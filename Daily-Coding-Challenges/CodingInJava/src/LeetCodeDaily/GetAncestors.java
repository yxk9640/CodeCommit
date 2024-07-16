package LeetCodeDaily;

import java.util.*;

public class GetAncestors {
    public static void main(String[] args) {
        System.out.println(getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));

    }
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer>[] adjaList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjaList[i] = new ArrayList<>();
        }

        //reverse the edges
        for (int[] e:edges) {
            int start = e[0];
            int end = e[1];
            adjaList[end].add(start);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> ansestor = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            helper(i, adjaList, visited);
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (visited.contains(j)) ansestor.add(j);
            }
            ans.add(ansestor);

        }
        return ans;
    }

    public static void helper(int cur, List<Integer>[] adja, Set<Integer> visited){
        visited.add(cur);

        for (int neigh: adja[cur]){
            if (!visited.contains(neigh))
                helper(neigh, adja, visited);
        }
    }
}

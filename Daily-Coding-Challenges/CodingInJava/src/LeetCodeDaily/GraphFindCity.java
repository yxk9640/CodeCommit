package LeetCodeDaily;/*
 @yxk
*/

import java.util.*;

public class GraphFindCity {
    public static void main(String[] args) {
        System.out.println(findTheCity(5, new int[][]
                {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
    }
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF =(int) 1e9 + 7;
        int[][] distMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distMatrix[i], INF);
            distMatrix[i][i] = 0; // dist to itself
        }

        for (int[] edge: edges){
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            distMatrix[start][end] = weight;
            distMatrix[end][start] = weight;

        }

        floyd(n, distMatrix);


        return getLowestCity(n, distMatrix, distanceThreshold);
    }

    static void floyd(int n, int[][] distMatrix){
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distMatrix[i][j] = Math.min(distMatrix[i][j],
                            distMatrix[i][k] + distMatrix[k][j] );

                }
            }
        }
    }

    static int getLowestCity(int n, int[][] distMatrix, int distThreshold){
        int lowCity = -1;
        int fewCount = n;

        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (i == j){
                    continue;
                }
                if (distMatrix[i][j] <= distThreshold)
                    cur++;
            }
            if ( cur <= fewCount){
                fewCount = cur;
                lowCity = i;
            }

        }


        return lowCity;
    }


}

import java.util.Arrays;

public class StringChangeCost {
    public static void main(String[] args) {
        System.out.println(minimumCost("abcd","acbe",
                new char[]{'a','b','c','c','e','d'}, new char[]{'b','c','b','e','b','e'},
                new int[]{2,5,5,1,2,20}
        ));
    }
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long finalCost = 0;

        // Step-1
        long[][] minCost = new long[26][26];
        for (long[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        //Step-2
        for (int i = 0; i < original.length; i++) {
            int start = original[i] - 'a';
            int end = changed[i] - 'a';
            minCost[start][end] = Math.min(minCost[start][end], (long) cost[i]);
        }

        //step-3
        for (int k = 0; k < 26; k++) {
            for (int j = 0; j < 26; j++) {
                for (int i = 0; i < 26; i++) {
                    minCost[i][j] = Math.min(minCost[i][j], minCost[i][k]+minCost[k][j]);
                }
            }
        }

//        Step-4
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) continue;;
            int src = source.charAt(i) - 'a';
            int tar = target.charAt(i) - 'a';
            if (minCost[src][tar] >= Integer.MAX_VALUE) return -1;
            finalCost += minCost[src][tar];
        }

        return finalCost;
    }
}

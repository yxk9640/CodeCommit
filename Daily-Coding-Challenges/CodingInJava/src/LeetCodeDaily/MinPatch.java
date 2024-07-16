package LeetCodeDaily;

import java.util.*;

public class MinPatch {
    public static void main(String[] args) {
//        System.out.println(minPatches(new int[]{1,3}, 6));
        System.out.println(minPatches(new int[]{1,5,10}, 20));
    }
    public static int minPatches(int[] nums, int n) {
        int minOper = 0;
        Set<Integer> sums = new HashSet<>();
        List<Integer> reqNums = new ArrayList<>();
        for (int j :nums) {
            reqNums.add(j);
        }

        for (int i = 1; i <= 20; i++) {
            sums = getSubsetSums(reqNums);
//            System.out.println(sums);
            System.out.println(reqNums);
            if ( !sums.contains(i)){
                reqNums.add(i);
                minOper++;
            }
        }
      return minOper;
    }

    public static Set<Integer> getSubsetSums(List<Integer> nums) {
        Set<Integer> subsetSums = new HashSet<>();
        int n = nums.size();
        int totalSubsets = 1 << n; // 2^n subsets

        for (int i = 1; i < totalSubsets; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += nums.get(j);
                }
            }
            subsetSums.add(sum);
        }

        return subsetSums;
    }
}

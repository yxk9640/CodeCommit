package LeetCodeDaily;

import java.util.Arrays;

public class MinIncToUnique {
    public static void main(String[] args) {
//        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
        System.out.println(minIncrementForUnique(new int[]{1,2,2}));
    }
    public static int minIncrementForUnique(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        int i = 1;
        while (i < nums.length){
           while (nums[i] == nums[i-1]){
               nums[i]++;
               moves++;
               Arrays.sort(nums);
           }
            i++;

        }
//        System.out.println(Arrays.toString(nums));

        return moves;
    }
}

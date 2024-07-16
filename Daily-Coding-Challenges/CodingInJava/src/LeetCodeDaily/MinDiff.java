package LeetCodeDaily;

import java.util.Arrays;

public class MinDiff {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{1,5,0,10,14}));
    }
    public static int minDifference(int[] nums){
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        if (nums.length <= 4) return 0;

        for (int left = 0, right = nums.length-4 ; left < 4 ; left++, right++) {
            int curDiff = nums[right]-nums[left];
            minDiff = Math.min(minDiff, curDiff );
        }

        return minDiff;
    }
}

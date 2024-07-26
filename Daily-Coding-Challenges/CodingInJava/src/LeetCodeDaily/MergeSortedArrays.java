package LeetCodeDaily;/*
 @yxk
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortedArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 2, 3, 1})));
    }
    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        int pivot = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left, right);

    }

    public static int[] merge(int[] a1, int[] a2){
        int s1 = a1.length, s2 = a2.length;
        int[] res = new int[s1 + s2];
        int l = 0, r = 0, cur = 0;

        while (l < s1 && r < s2){
            if ( a1[l] < a2[r]){
                res[cur++]=a1[l++];
            }
            else {
                res[cur++]=a2[r++];
            }
        }

        while ( l < s1){
            res[cur++]=a1[l++];
        }
        while ( r < s2){
            res[cur++]=a1[r++];
        }

        return res;
    }
}

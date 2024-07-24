package LeetCodeDaily;/*
 @yxk
*/

import java.util.Arrays;
import java.util.HashMap;

public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort(new int[]{1,1,2,2,2,3}));
    }

    public static int[] frequencySort(int[] nums) {
        Integer[] result = new Integer[nums.length];
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1 );
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }

        Arrays.sort(result, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))){
                return Integer.compare(b,a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
//        System.out.println(Arrays.toString(nums));

        return nums;
    }

}

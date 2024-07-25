package LeetCodeDaily;/*
 @yxk
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortJumbled {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6},
                new int[]{991, 338, 38})));

//        System.out.println(Arrays.toString(sortJumbled(new int[]{9,8,7,6,5,4,3,2,1,0},
//                new int[]{0,1,2,3,4,5,6,7,8,9})));
    }
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int[] res = new int[nums.length];
        List<int[]> idx = new ArrayList<int[]>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                idx.add(new int[]{mapping[0],i});
                continue;
            }
            if (nums[i] != 0){
                idx.add(new int[]{replace(nums[i], mapping), i});
            }
        }
        idx.sort((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < idx.size(); i++) {
            res[i] = nums[idx.get(i)[1]];

        }
        return res;
    }
    private static int replace(int digit, int[] mapping){
        int ans = 0, temp = digit, i = 1;

        // 991
        while (temp > 0){
            int c =  temp%10;
            ans += (int) (mapping[c] * i);

            temp /= 10;
            i*=10;
        }

        return ans;
    }
}

package LeetCodeDaily;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinKFlips {
    public static void main(String[] args) {
        System.out.println(minKBitFlips(new int[]{0,1,0}, 1));
    }
    public static int minKBitFlips(int[] nums, int k) {
//        fixed window length = k
        int result = 0, flip = 0;
        Deque<Integer> flipQ = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if ( i >= k){
                flip ^= flipQ.poll();
            }

            if (flip == nums[i]){
                if ( i+k > nums.length){
                    return -1;
                }
                flipQ.offer(1);
                flip^=1;
                result++;
            }else {
                flipQ.offer(0);
            }
        }

        return  result;
    }
}

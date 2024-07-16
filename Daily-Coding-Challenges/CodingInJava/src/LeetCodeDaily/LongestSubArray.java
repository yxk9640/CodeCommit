package LeetCodeDaily;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestSubArray {
    public static void main(String[] args) {
//        System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));
        System.out.println(longestSubarray(new int[]{10,1,2,4,7,2}, 5));
//        System.out.println(longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }
    public static int longestSubarray(int[] nums, int limit) {
        int longSub = 0, left = 0;
        // store min at first
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // for max
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for (int right = 0; right < nums.length ; right++) {
            maxHeap.offer(new int[]{nums[right], right});
            minHeap.offer(new int[]{nums[right], right});

//            check and update min and max value with changing window size
            while ( maxHeap.peek()[0] - minHeap.peek()[0] > limit){
//                update window length
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1])+1;

                while (maxHeap.peek()[1] < left)
                    maxHeap.poll();
                while (minHeap.peek()[1] < left)
                    minHeap.poll();
            }
            longSub = Math.max(longSub, right - left + 1);

        }


        return longSub;
    }
}

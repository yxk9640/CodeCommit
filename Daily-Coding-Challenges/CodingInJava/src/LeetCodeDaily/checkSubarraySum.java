package LeetCodeDaily;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class checkSubarraySum {
	public static void main(String[] args) {
		System.out.println(checkSubarraySum(new int[] {23,2,4,6,7}, 6));
//		System.out.println(checkSubarraySum(new int[] {0,0}, 6));
		
	}
	public static boolean checkSubarraySum(int[] nums, int k) {
		if (nums.length == 2) {
			return (nums[0]+nums[1])%k == 0;
		}
		int sum = nums[0]+nums[1];
		System.out.println(sum+" : "+0);
		for (int i = 1; i < nums.length-1; i++) {
			sum = nums[i+1]- nums[i-1];
			System.out.println(sum+" : "+i);
		}
			
		
		
		
		
		return false;        
    }

}

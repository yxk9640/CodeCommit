package LeetCodeDaily;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortColors(new int[] {2,0,2,1,1,0});

	}
	
	public static void sortColors(int[] nums) {
        int left = 0, right = nums.length-1, i = 0;
        while (left <= right) {
        	if (nums[i] == 0) {
//				swap
        		swap(nums, left, i);
        		left++;
			}
        	else if (nums[i]==2) {
//	        		 swap
	        		swap(nums, i, right);
					right--;
//					we sholud not increment i 
//					because current swap may put least values
//					at the left of i and would skip if incremented 
//					so line 30 and line 32 will cancel in this case
					i--;
				} 
        	i++;
			
		}
        System.out.println(Arrays.toString(nums));
    }
	
	public static int[] swap(int[] arr, int i, int j) {
		arr[i]^=arr[j];
		arr[j]^=arr[i];
		arr[i]^=arr[j];
		return arr;
	}

}

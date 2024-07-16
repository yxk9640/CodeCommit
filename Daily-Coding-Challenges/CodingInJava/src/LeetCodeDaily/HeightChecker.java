package LeetCodeDaily;

import java.util.Arrays;
import java.util.Iterator;

public class HeightChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(heightChecker(new int[] {1,1,4,2,1,3}));
	}
	public static int heightChecker(int[] heights) {
        int idxCount = 0;
        int[] expected = merge_sort(heights);
//        Arrays.sort(expected);
//        System.out.println(Arrays.toString(merge_sort(heights)));
        
        for (int i = 0; i < expected.length; i++) {
			if (heights[i] != expected[i]) {
				idxCount++;
			}
		}
        return idxCount;
    }
	
	public static int[] merge_sort(int[] array) {
		if(array.length <= 1) return array;
		
		int pivot = array.length / 2;
		int[] left = merge_sort(Arrays.copyOfRange(array, 0, pivot));
		int[] right = merge_sort(Arrays.copyOfRange(array, pivot, array.length));
		
		return merge(left, right); 
		
	}
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length+arr2.length];
        int left = 0, right = 0, cur = 0;

        while (left < arr1.length && right < arr2.length){
            if( arr1[left] < arr2[right]){
                result[cur++] = arr1[left++];
            }else{
                result[cur++] = arr2[right++];
            }
        }

        while(left < arr1.length){
            result[cur++] = arr1[left++];
        }
        while(right < arr2.length){
            result[cur++] = arr2[right++];
        }

        return result;
		
	}

}

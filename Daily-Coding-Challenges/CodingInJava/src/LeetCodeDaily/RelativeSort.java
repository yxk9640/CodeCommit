package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RelativeSort {
	public static void main(String[] args) {

		System.out.println( canThreePartsEqualSum(new int[] {3,3,6,5,-2,2,5,1,-9,4})  );
	}

	public static boolean canThreePartsEqualSum(int[] arr) {
        int backSum = arr[arr.length-1], frontSum = arr[0], midSum=0;
        int left =0, right = arr.length-1;
        
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

		
		return (midSum==frontSum && midSum==backSum)? true:false;
    }
}

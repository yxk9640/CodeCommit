package LeetCodeDaily;

public class SubarraysDivByK {
	public static void main(String[] args) {
		System.out.println(subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5));
	}
	public static int subarraysDivByK(int[] nums, int k) {
        int subCount = 0;
        for (int i = 0; i < nums.length; i++) {
			int j = i;
			int curSum = 0;
			while (j < nums.length) {
				curSum += nums[j];
//				System.out.println(curSum+" "+i +" "+nums[j]);
				j++;
				if (curSum % k == 0) {
					subCount++;
				}
				
			}
		}
		
		return subCount;
    }

}

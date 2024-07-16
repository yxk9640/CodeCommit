package LeetCodeDaily;

import java.util.Arrays;

public class MaxCustSatisfied {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

//        calculate max customers during grumpy times
        int unsatisfy = 0;
//        initialize
        for (int i = 0; i < minutes ; i++) {
            unsatisfy += customers[i] * grumpy[i];
        }
//        slide
        int maxCust = unsatisfy;
        for (int i = minutes; i < n ; i++) {
            unsatisfy += (customers[i]*grumpy[i]);
            unsatisfy -= (customers[i-minutes]*grumpy[i-minutes]);
            maxCust = Math.max(maxCust, unsatisfy);
        }

//        calculate customers during non-grumpy times
        int totalCus = maxCust;

        for (int i = 0; i < n; i++) {
            totalCus += customers[i]*(1-grumpy[i]);
        }
         return totalCus;
    }


}

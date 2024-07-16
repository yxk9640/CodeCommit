package LeetCodeDaily;

public class MinBloomDays {
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1,10,3,10,2}, 3,  1));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if( m * k > bloomDay.length ) return -1;
        // we need to search for min day and we use range of array to get that
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i: bloomDay){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        while (low < high){
            int mid = (low + high ) / 2;
            if (bouquetCount(bloomDay, m, k, mid))
                high = mid ;
            else low = mid + 1;

        }
        return low;
    }

    public static boolean bouquetCount(int[] arr, int m, int k, int day){
        int bouq = 0;
        int flower = 0;

        for (int d: arr){
            if ( d <= day){
                flower++;
                if (flower == k){
                    bouq++;
                    flower=0;
                }
            }else {
                flower = 0;
            }
        }

        return bouq >=m;
    }
}

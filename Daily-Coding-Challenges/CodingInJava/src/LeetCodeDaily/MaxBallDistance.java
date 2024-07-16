package LeetCodeDaily;

import java.util.Arrays;

public class MaxBallDistance {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1,2,3,4,7}, 3));
    }
    public static int maxDistance(int[] position, int m) {
        int res = 0;
        Arrays.sort(position);
        int l = 0, r = position[position.length-1] - position[0];
        while ( l <= r){
            int mid = l + (r - l ) / 2;
            if ( canPlaceBall(position, m , mid)){
                res = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return res;
    }

    public static boolean canPlaceBall(int[] position, int m, int force){
        int count = 1;
        int lastPos = position[0];

        for (int i = 0; i < position.length; i++) {
            if ( position[i] - lastPos >= force){
                count++;
                lastPos = position[i];
                if (count == m)
                    return true;
            }
        }
        return false;
    }
}

package LeetCodeDaily;

public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
//        System.out.println(judgeSquareSum(3));
    }
    public static boolean judgeSquareSum(int c) {
//       b*b = c - a*a;
        for (int a = 0; a*a <= c; a++) {
            int b = c -(int) (a*a);
           if (binary(0, b, b))
               return true;

        }
        return false;
    }

    public static boolean binary(long start, long end, int target){
        if (start > end)
        return false;
        else {
            long mid = start + (end - start ) / 2;
            if ( mid* mid == target)
                return true;
            else if (mid * mid > target){
                binary(start, mid-1, target);
            }
            else binary(mid+1, end, target);
        }
        return false;
    }
}

package LeetCodeDaily;

import java.util.Arrays;

public class SolutionJun01 {
    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }
    public static void reverseString(char[] s) {
        if (s == null)
            return;
        helper(s, 0 , s.length-1);
        System.out.println(Arrays.toString(s));

    }
    private static void helper(char[] s, int left, int right) {
        if ( left >= right )
            return;
        s[left]^=s[right];
        s[right]^=s[left];
        s[left]^=s[right];
        helper(s, left+1, right - 1);
    }
}

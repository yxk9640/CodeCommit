package LeetCodeDaily;

import java.util.HashMap;
import java.util.Map;

public class LongPalindrome {
    public static void main(String[] args) {
        System.out.println(canBeEqual("abcd", "cdab"));
        System.out.println(canBeEqual("abcd", "dacb"));
        System.out.println(canBeEqual("bnxw","bwxn"));
    }

    public static boolean canBeEqual(String s1, String s2) {

        if (s1.equals(s2))
            return true;
        else {
//            System.out.println(s1.charAt(0));
//            System.out.println(s2.charAt(0));
            if (s1.charAt(0) != s2.charAt(0))// swap 0,2
            {
                StringBuilder str = new StringBuilder(s1);
                char tmp = str.charAt(0);
                str.setCharAt(0, str.charAt(2));
                str.setCharAt(2, tmp);
                s1 = str.toString();
            }

            if (s1.charAt(1) != s2.charAt(1)) {// swap 0,2
                StringBuilder str = new StringBuilder(s1);
                char tmp = str.charAt(1);
                str.setCharAt(1, str.charAt(3));
                str.setCharAt(3, tmp);
                s1 = str.toString();
            }
        }

        return s1.equals(s2)? true:false;
    }
}

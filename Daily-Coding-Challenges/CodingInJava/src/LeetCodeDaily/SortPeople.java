package LeetCodeDaily;/*
 @yxk
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortPeople {
    public static void main(String[] args) {
        System.out.println(sortPeople(new String[]{"Mary","John","Emma"},
                new int[]{180,165,170}));
    }
    public static String[] sortPeople(String[] names, int[] heights) {
        String[] res = new String[names.length];
        HashMap<Integer, String> indx = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            indx.put(heights[i],names[i]);
        }
        Arrays.sort(heights);

        for (int i = heights.length - 1; i >= 0; i--) {
            res[heights.length - i-1] = indx.get(heights[i]);
        }
        System.out.println(Arrays.toString(res));

        return res;
    }
}

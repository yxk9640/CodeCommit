package LeetCodeDaily;

import java.util.Stack;

/**
 * @author - yogesh
 */
public class MinOperations {
    public static void main(String[] args) {
//        System.out.println(minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
        System.out.println(minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
    }
    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        String parent = "../", same = "./";

        for (String c: logs){
            if ( c.equals(parent))
                stack.pop();
            else if (c.equals(same))
                continue;
            else stack.add(c);
        }
        System.out.println(stack);


        return stack.size();

    }
}

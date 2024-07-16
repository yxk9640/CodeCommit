package LeetCodeDaily;

import java.util.Stack;

/**
 * @author - yogesh
 */
public class ReverseParanthesis {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(u(love)i)"));
    }
    public static String reverseParentheses(String s) {
//        String res = "";
        Stack<Integer> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (char c: s.toCharArray()){
            if (c == ')' ){
                int start = stack.pop();
                rev(temp, start, temp.length()-1);
            } else if (c == '('){
                stack.push(temp.length());
            }else {
                temp.append(c);
            }
        }

        System.out.println(stack);

        return temp.toString();
    }

    public static void rev(StringBuilder str, int startIdx, int endIdx){
        while (startIdx < endIdx) {
            char temp = str.charAt(startIdx);
            str.setCharAt(startIdx++, str.charAt(endIdx));
            str.setCharAt(endIdx--, temp);
        }
    }
}

package LeetCodeDaily;

import java.util.Stack;

/**
 * @author - yogesh
 */
public class MaxGainStack {
    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab",4,5));

    }
    public static int maximumGain(String s, int x, int y) {
        int maxScore = 0;

        if ( x > y){
            // focus on ab : cdbcbbaaabab
            Stack<Character> stack = new Stack<>();
            for (char alpha: s.toCharArray()){
                if ( alpha == 'b' && stack.peek()=='a' ){
                    maxScore+=x;
                }stack.push(alpha);
            }
            System.out.println(stack);
        }

        if ( x < y){
            // focus on ba
            // focus on ab : cdbcbbaaabab
            Stack<Character> stack = new Stack<>();
            for (char alpha: s.toCharArray()){
                if ( alpha == 'a' && stack.peek()=='b' ){
                    maxScore+=y;
                }stack.push(alpha);
            }
            System.out.println(stack);
        }
        System.out.println();
        return maxScore;
    }
}

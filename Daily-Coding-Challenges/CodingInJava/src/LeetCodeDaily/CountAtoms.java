package LeetCodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author - yogesh
 */
public class CountAtoms {
    public static void main(String[] args) {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
//        System.out.println(countOfAtoms("H2O2He3Mg4"));
    }
    public static String countOfAtoms(String formula) {
        String res = "";

        Stack<Character> stack = new Stack<>();
        List<Character> inPara = new ArrayList<>();

        for (char c: formula.toCharArray()){
            // implement ( and )
            if (c==')'){


            }else{ stack.push(c);}


            // implement uppercase
        }
        System.out.println(stack+" Stack");
        System.out.println(inPara+" List");

        return res;
    }
}

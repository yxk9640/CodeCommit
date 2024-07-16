package LeetCodeDaily;

import java.util.*;

/**
 * @author - yogesh
 */
public class RobotSurvive {
    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths(new int[]{5,4,3,2,1},
                new int[]{2,17,9,15,10},"RRRRR"));
    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        //sort robots based on positions
        HashMap<Integer, Integer> posIdx = new HashMap<>();
        for (int i = 1; i <= positions.length; i++) {
            posIdx.put(i,positions[i-1]);
        }
        Arrays.sort(positions);
        for (int p: positions){
            int j = posIdx.get(p)-1;

            if (directions.charAt(j) == 'R'){
                stack.push(j);
            }else { //Robot moving to Left
                while ( !stack.isEmpty() && directions.charAt(stack.peek()) == 'R' && healths[j]>0){
                    int k = stack.pop();
                    if (healths[j] > healths[k]){
                        healths[k]=0;
                        healths[j]--;
                    }else if(healths[j] < healths[k]){
                        healths[k]--;
                        healths[j]=0;
                        stack.push(k);
                    }else {
                        healths[j] = healths[k] = 0;
                    }

                }
            } if(healths[j]>0) stack.push(j);

        }

        for (int h: healths){
            if (h>0) res.add(h);
        }


        return res;
    }
}

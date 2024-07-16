package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxProfitAssign {
    public static void main(String[] args) {
//        System.out.println(maxProfitAssignment(
//                new int[]{2,4,6,8,10}, new int[]{10,20,30,40,50},
//                new int[]{4,5,6,7}
//        ));
//        System.out.println(maxProfitAssignment(
//                new int[]{85,47,57}, new int[]{24,66,99},
//                new int[]{40,25,25}
//        ));
        System.out.println(maxProfitAssignment(
                new int[]{13,37,58}, new int[]{4,90,96},
                new int[]{34,73,45}
        ));
    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;

        List<int[]> job = new ArrayList<>();
        job.add(new int[]{0,0}); //difficulty, profit
        for (int i = 0; i < difficulty.length; i++) {
            job.add(new int[]{difficulty[i], profit[i]});
        }

        Collections.sort(job, (a,b) -> Integer.compare(a[0], b[0]));
        for (int j = 0; j < job.size()-1; j++) {
            job.get(j+1)[1] = Math.max(
                    job.get(j)[1], job.get(j+1)[1]
            );
        }


//        Arrays.sort(difficulty);

        for (int w = 0; w < worker.length ; w++) {
            int curW = worker[w];

            int l = 0, r = job.size()-1, curProf = 0;
            while ( l <= r){
                int mid = ( l + r) / 2;
                if( job.get(mid)[0] <= curW){
                    curProf = Math.max(curProf, job.get(mid)[1]);
                    l = mid + 1;
                }else r = mid - 1;
            }
            maxProfit += curProf;
        }
        return maxProfit;
    }
}

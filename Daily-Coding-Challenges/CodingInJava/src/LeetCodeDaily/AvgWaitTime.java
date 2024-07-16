package LeetCodeDaily;

public class AvgWaitTime {
    public static void main(String[] args) {
    System.out.println(averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
    }
    public static double averageWaitingTime(int[][] customers) {
        int  chefCook = 0, n = customers.length;
        long cusWait = 0;
        for (int i = 0; i < n ; i++) {
            chefCook = Math.max(chefCook,customers[i][0]) + customers[i][1];
            cusWait += chefCook - customers[i][0]  ;
        }

        return (double) cusWait/n;
    }
}

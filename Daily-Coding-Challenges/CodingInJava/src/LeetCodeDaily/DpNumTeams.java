package LeetCodeDaily;/*
 @yxk
*/

public class DpNumTeams {
    public static void main(String[] args) {
        System.out.println(numTeams(new int[]{2,5,3,4,1}));
    }
    public static int numTeams(int[] rating) {
        int n = rating.length, teams = 0;
        Integer[][] increase = new Integer[n][4];
        Integer[][] decrease = new Integer[n][4];

        for (int i = 0; i < n; i++) {
            teams+=
            increaseTeam(rating, i, 1, increase) +
                    decreaseTeam(rating, i, 1, decrease);
        }
        return teams;
    }

    public static int increaseTeam(int[] rating,int cur, int team, Integer[][] increase){
        int n1 = rating.length;
        if (cur == n1) return 0;
        if (team == 3) return 1;
        if (increase[cur][team] != null) return increase[cur][team];
        int validTeam = 0;
        for (int i = cur+1; i < n1; i++) {
            if (rating[i] > rating[cur]){
                validTeam += increaseTeam(rating, i, team+1, increase);
            }

        }
        return increase[cur][team] = validTeam;
    }

    public static int decreaseTeam(int[] rating, int cur, int team, Integer[][] decrease){
        int n2 = rating.length;
        if (cur == n2) return 0;
        if (team == 3) return 1;
        if (decrease[cur][team] != null) return decrease[cur][team];

        int validTeam = 0;

        for (int j = cur+1; j < n2; j++) {
            if ( rating[j] < rating[cur]){
                validTeam += decreaseTeam(rating, j, team+1,decrease );
            }

        }
        return decrease[cur][team] = validTeam;
    }
}

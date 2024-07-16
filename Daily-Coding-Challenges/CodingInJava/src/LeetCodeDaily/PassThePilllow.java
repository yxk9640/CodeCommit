package LeetCodeDaily;

public class PassThePilllow {
    public static void main(String[] args) {
//        System.out.println(passThePillow(4,5));
        System.out.println(passThePillow(3,2));
    }
    public static int passThePillow(int n, int time) {
        int i = 1, t = 0;
        int res = 0;
        while (t < time){
            if (i >= -1){
                i++;
                System.out.println(i+" for");
            }

            if (i > n){
                i = (i-n)%n;
                System.out.println( (i-n) +" back");
            }

            t++;
            res = i;
        }
        return res;
    }
}

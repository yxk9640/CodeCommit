package LeetCodeDaily;

public class Solutions {
    public static void main(String[] args) {
     System.out.println(scoreOfString("hello"));//13
    }
    public static int scoreOfString(String s) {
        int sum = 0;
        for (int c = 0; c < s.length() - 1; c++){
            sum+=Math.abs((int) s.charAt(c)-s.charAt(c+1));
        }
        return sum;
    }
}

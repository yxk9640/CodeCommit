package LeetCodeDaily;

public class AppenChar {
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching","coding"));
        System.out.println(appendCharacters("z","abcde"));
    }
    public static int appendCharacters(String s, String t) {
        if (s.equals(t)) return 0;
        int count = 0,i = 0, j =0;
        while (i < s.length()){
            if (j < t.length() && s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                count++;
            }
            else i++;
            if (j == t.length()) return 0;

        }

        return t.length() - count;
    }
}

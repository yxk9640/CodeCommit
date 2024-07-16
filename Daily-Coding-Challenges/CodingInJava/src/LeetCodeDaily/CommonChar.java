package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CommonChar {
	public static void main(String[] args) {
		System.out.println(commonChars(new String[]{"bella","label","roller"}));
	}
	public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int[] common = new int[26];
        int[] current = new int[26];

        for(char c: words[0].toCharArray()){
            common[c-'a']++;
        }

        for(int i = 0; i < words.length; i++){
            Arrays.fill(current, 0);

            for(char ch: words[i].toCharArray()){
                current[ch-'a']++;
            }

            for(int l = 0; l < 26; l++){
                common[l] = Math.min(current[l],common[l]);
            }
        }

        for(int le = 0; le < 26; le++){
            for(int o = 0; o < common[le]; o++){
                res.add( String.valueOf((char)(le+'a')) );
            }
        }

        return res;
    }
	
   

}

#Update sliding window question with

## 3. Longest Substring Without Repeating Characters
in java code
```
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLen = 0, i = 0, j = 0;
        
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        
        return maxLen;
    }
}

/*
len = 3
abcabcbb

set = (a,b,c) break
 
*/

```

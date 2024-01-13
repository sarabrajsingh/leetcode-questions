import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // public static int lenghtOfLongestSubstring(String s) {
    //     int n = s.length();
    //     int res = 0;

    //     for(int i = 0; i < n; i++) {
    //         for(int j = i; j < n; j++) {
    //             if(checkRep(s, i, j)) {
    //                 res = Math.max(res, j - i + 1);
    //             }
    //         }
    //     }

    //     return res;
    // }
    // public static boolean checkRep(String s, int start, int end) {
    //     Set<Character> chars = new HashSet<>();
    //     for(int i = start; i <= end; i++) {
    //         char c = s.charAt(i);
    //         if(chars.contains(c)) {
    //             return false;
    //         }
    //         chars.add(c);
    //     }
    //     return true;
    // }
    // public static int lenghtOfLongestSubstring(String s) {
    //     Map<Character, Integer> map = new HashMap<>();
        
    //     // pointers
    //     int left = 0;
    //     int right = 0;

    //     int res = 0;

    //     while(right < s.length()) {
    //         char c = s.charAt(right);
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //         while(map.get(c) > 1){
    //             // get the char that the left pointer is pointing to
    //             char l = s.charAt(left);
    //             // decrement the value of the the char that l is pointing to
    //             map.put(l, map.get(l)-1);
    //             // increment the left pointer
    //             left++;
    //         }
    //         res = Math.max(res, right - left + 1);
    //         right++;
    //     }

    //     return res;
    // }

    public static int lenghtOfLongestSubstring(String s){ 
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;
        int n = s.length();

        for(int i = 0, j = 0; j < n; j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(String.format("res=%d", lenghtOfLongestSubstring("pwwkew")));
    }
    
}

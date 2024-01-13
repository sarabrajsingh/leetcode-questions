import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int res = 0;
        int max_o = 0;
        int[] arr = new int[26]; // 26 uppercase characters
        for(int right = 0; right < s.length(); right++) {
            arr[s.charAt(right) - 'A']++; // minus capital 'A' from the character int value to get it's relative position in the array
            max_o = Math.max(max_o, arr[s.charAt(right) - 'A']);
            if(right - left + 1 - max_o > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, (right - left + 1));
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}

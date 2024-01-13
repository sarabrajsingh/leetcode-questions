import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[] frequency_array_1 = new int[26];
        int[] frequency_array_2 = new int[26];

        for (int i = 0; i < n; i++) {
            frequency_array_1[s1.charAt(i) - 'a']++; // offset the actual character with the ascii code for 'a'
        }

        for (int i = 0; i < m; i++) {
            frequency_array_2[s2.charAt(i) - 'a']++;
            if (i >= n) {
                frequency_array_2[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(frequency_array_1, frequency_array_2))
                return true;
        }

        return false;
    }
}
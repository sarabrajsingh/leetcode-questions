public class Solution {
    public static boolean isPalindrome(String s){
        for(int i  = 0, j = s.length() - 1; i < j; i++, j--) {
            // move the left pointer to the first valid character / to the right
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            // move the right pointer to the first valid character / to the left
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // now evaluate the character at the left and right pointers
            // convert to lowercase
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }

        return true;
    }    
}

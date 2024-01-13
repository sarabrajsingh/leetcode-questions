import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
        int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(nums2);

    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> theSet = new HashSet<>();
        for (int num : nums) {
            theSet.add(num);
        }

        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!theSet.contains(nums[i] - 1)) {
                int length = 1;
                while (theSet.contains(nums[i] + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
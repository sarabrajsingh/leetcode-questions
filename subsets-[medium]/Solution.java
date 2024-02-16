import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();

        helper(res, subAns, nums, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> subAns, int[] nums, int startIdx) {
        // bounds
        if (startIdx > nums.length - 1) {
            res.add(new ArrayList<Integer>(subAns));
            // recursion ends here
        } else {
            subAns.add(nums[startIdx]);
            helper(res, subAns, nums, startIdx+1); // will generate a sequential array like [1,2,3]
            subAns.remove(subAns.size() - 1);
            helper(res, subAns, nums, startIdx+1); // will generate the permutations like [1,2] and [1,3]
        }   
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
}
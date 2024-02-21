class Solution{
    public static boolean canJump(int[] nums) {
        int goal_idx = nums.length-1;

        for(int i = goal_idx-1; i >= 0; i--) {
            int jump = nums[i];
            if(jump + i >= goal_idx) {
                goal_idx = i;
            }
        }

        return goal_idx == 0;
    }
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
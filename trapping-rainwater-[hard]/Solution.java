class Solution {
    public static int trap(int[] height) {

        int resp = 0;

        int[] maxLeftArr = new int[height.length];
        int[] maxRightArr = new int[height.length];

        int[] minLR = new int[height.length];

        int maxLeftTracker = Integer.MIN_VALUE;
        int maxRightTracker = Integer.MIN_VALUE;

        for(int i = 0; i < height.length; i++) {
            if(i == 0) {
                maxLeftArr[0] = 0;
                maxLeftTracker = 0;
            }

            maxLeftArr[i] = maxLeftTracker;
            maxLeftTracker = Math.max(maxLeftTracker, height[i]);
        }

        for(int i = height.length-1; i >= 0; i--) {
            if(i == height.length-1) {
                maxRightArr[i] = 0;
                maxRightTracker = 0;
            }

            maxRightArr[i] = maxRightTracker;
            maxRightTracker = Math.max(maxRightTracker, height[i]);
        }

        for(int i = 0; i < minLR.length; i++) {
            minLR[i] = Math.min(maxLeftArr[i], maxRightArr[i]);
        }

        for(int i = 0; i < height.length; i++) {
            int count = minLR[i] - height[i];
            if(count <= 0) count = 0;

            resp += count;
        }

        return resp;
    }
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
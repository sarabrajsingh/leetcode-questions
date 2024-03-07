public class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++){
            right = Math.max(right, piles[i]);
        }

        int res = right;

        while(left <= right) {
            int mid = (left + right) / 2;
            int total_hours = 0;

            for(int pile: piles) {
                total_hours += Math.ceil((double)pile / mid);
            }

            if(total_hours <= h){
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}

import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer arg0, Integer arg1) {
        if (arg0 < arg1) return -1;
        if (arg0 > arg1) return 1;
        return 0;
    }
}

class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());

        for(int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int counter  = 0;
        while(counter < k - 1) {
            maxHeap.poll();
        }

        return maxHeap.poll();
    }
}
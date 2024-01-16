import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {

        if (minHeap.size() < k)
            minHeap.add(val);
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }

        return minHeap.peek();
    }
}

class Solution {
    public static void main(String[] args) {
        KthLargest k = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        k.add(3);
        k.add(5);
        k.add(10);
        k.add(9);

        System.out.println(k.add(4));
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }
        
        while(maxHeap.size() > 1) {
            int stone_1 = maxHeap.poll();
            int stone_2 = maxHeap.poll();

            if (stone_1 != stone_2) {
                maxHeap.add(stone_1 - stone_2);
            }
        }

        if(maxHeap.isEmpty()){
            return 0; 
        } else {
            return maxHeap.peek();
        }
    }
    public static void main(String[] args) {

    }
}

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class QueueObj {
    int value;
    int count;

    public QueueObj(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<QueueObj> maxHeap = new PriorityQueue<>(Comparator.comparingInt((QueueObj o) -> o.count).reversed());

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], 1 + map.getOrDefault(nums[i], 0));
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            QueueObj q = new QueueObj(value, count);

            maxHeap.add(q);
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++) {
            QueueObj o = maxHeap.poll();
            res[i] = o.value;
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
}

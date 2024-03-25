import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    static class QueueObject {
        int count;
        int idleTime;
        public QueueObject(int count, int idleTime){
            this.count = count;
            this.idleTime = idleTime;
        }
    }
    public static int leastInterval(char[] tasks, int n) {
        int time = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<QueueObject> q = new LinkedList<>();

        int[] arr = new int[26];

        for(char c : tasks) { 
            arr[c - 'A']++;
        }

        for(int val : arr) {
            if (val > 0) {
                maxHeap.add(val);
            }
        }

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if(!maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                task--;
                if (task > 0) { QueueObject o = new QueueObject(task, time + n); q.add(o); }
            }

            if(!q.isEmpty() && q.peek().idleTime == time) {
                maxHeap.add(q.poll().count);
            }
        }

        return time;
    }

    public static void Main(String[] args) {

    }
}
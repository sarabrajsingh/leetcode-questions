import java.util.Comparator;
import java.util.PriorityQueue;

class QueueObj {
    int[] point;
    double distance;
}

class MyComparator implements Comparator<QueueObj> {

    @Override
    public int compare(QueueObj x, QueueObj y) {
        if(x.distance < y.distance) return -1;
        if(x.distance > y.distance) return 1;
        return 0;
    }
}

class Solution {
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<QueueObj> minHeap = new PriorityQueue<>(new MyComparator());

        for (int[] point : points) {
            double e = euclidean(point);
            QueueObj o = new QueueObj();
            o.point = point;
            o.distance = e;

            minHeap.add(o);
        }

        int[][] resF = new int[k][2];
        for (int i = 0; i < k; i++) {
            QueueObj o = minHeap.poll();
            resF[i] = o.point;
        }

        return resF;
    }

    private static double euclidean(int[] point) {
        int x1 = point[0];
        int x2 = 0;

        int y1 = point[1];
        int y2 = 0;

        double x1x2squared = Math.pow((x1 - x2), 2);
        double y1y2squared = Math.pow((y1 - y2), 2);

        return Math.sqrt(x1x2squared + y1y2squared);
    }

    public static void main(String[] args) {
        int[] a1 = new int[] { 1, 3 };
        int[] a2 = new int[] { -2, 2 };

        System.out.println(kClosest(new int[][] { a1, a2 }, 1));
    }
}
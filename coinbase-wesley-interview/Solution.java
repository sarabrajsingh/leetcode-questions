import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Main class should be named 'Solution' and should not be public.
class MyComparator implements Comparator<Transaction> {

    @Override
    public int compare(Transaction arg0, Transaction arg1) {
        if (arg0.rank < arg1.rank) return 1;
        if (arg0.rank > arg1.rank) return -1;
        return 0;
    }

}

class Transaction {
    int id;
    int fee;
    int size;
    double rank;

    public Transaction(int id, int size, int fee) {
        this.id = id;
        this.fee = fee;
        this.size = size;
        this.rank = ((double)fee / size);
    }

    @Override
    public String toString() {
        return "id=" + this.id;
    }
}

class Solution {
    public static void mine_block(Transaction[] mempool) {

        int blockSize = 100;

        PriorityQueue<Transaction> maxHeap = new PriorityQueue<Transaction>(new MyComparator());

        for(int i = 0; i < mempool.length; i++) {
            maxHeap.add(mempool[i]);
        }

        List<Transaction> res = new ArrayList<>();

        while(!maxHeap.isEmpty()) {
            if(blockSize == 0) {
                break;
            }
            
            Transaction t = maxHeap.poll();

            if(blockSize >= t.size) {
                res.add(t);
                blockSize -= t.size;
            }
        }

        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        Transaction[] test_mempool = new Transaction[]{
            new Transaction(1, 95, 500),
            new Transaction(2, 90, 50), 
            new Transaction(3, 30, 10), 
            new Transaction(4, 10, 100), // 10
            new Transaction(5, 20, 100), // 5
            new Transaction(6, 50, 50), // 1
            new Transaction(7, 20, 1), // 0.5
        };
        mine_block(test_mempool);
    }
}

/*
test_mempool = [
        Transaction(1, 10, 100), # First
        Transaction(2, 20, 100), # Second
        Transaction(3, 50, 50), # Third
        Transaction(4, 20, 1), # Fourth
        Transaction(5, 95, 500), # Skip (sub-optimal)
        Transaction(6, 90, 50), 
        Transaction(7, 30, 10), 
]
*/
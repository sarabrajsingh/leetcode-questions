from collections import Counter
import collections
import heapq
from typing import List

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        q = collections.deque() # pair of values [-cnt, idle_time]

        counts = Counter(tasks)
        
        maxHeap = [-cnt for cnt in counts.values()]

        heapq.heapify(maxHeap)

        time = 0

        while maxHeap or q:
            time += 1
            if maxHeap:
                current = 1 + heapq.heappop(maxHeap)
                if current:
                    q.append((current, time+n))

            if q and q[0][1] == time:
                work, _ = q.popleft()
                heapq.heappush(maxHeap, work)

        return time





if __name__ == '__main__':
    s = Solution()
    print(s.leastInterval(["A","A","A","B","B","B"], 2))
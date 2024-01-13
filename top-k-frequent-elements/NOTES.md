- think about how we can keep track of the frequency of each number that we encountered
- n*log(n) sorting is time consuming
- we only care about the top k most frequent elements
- anytime we want to find the top K elements of any problem, think of heap
- heaps are sorted trees - there are min-heaps and max-heaps
- min-heap is a complete binary tree - the value of each node is less than or equal to it's children

- step 1: create a hash-map and get the frequency of each number encountered
    key: unique integer
    value: frequency

- step 2: create the min-heap (priority-queue) -> we compare the frequencies of each node (get value from the hash-map)

- o(n) approach:
  think about d
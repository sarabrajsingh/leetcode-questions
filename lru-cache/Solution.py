class Node:
    def __init__(self, key, val):
        self.key, self.val = key, val
        self.prev = self.next = None

class LRUCache:
    """
    keep track of lru and mru with a left and right pointer
    """
    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = {} # maps the keys to nodes

        self.left, self.right = Node(0,0), Node(0,0) # left tracks LRU and right tracks MRU
        self.left.next, self.right.prev = self.right, self.left # have the nodes points to each other for LRU and MRU. this will make them easier to swap.

    def remove(self, node):
        prev, next = node.prev, node.next
        prev.next, next.prev = next, prev
    
    # always insert at Right and swap LRU and MRU
    def insert(self, node):
        prev, next = self.right.prev, self.right
        prev.next = next.prev = node
        node.next, node.prev = next, prev


    def get(self, key: int) -> int:
        if key in self.cache.keys():
            self.remove(self.cache[key])
            self.insert(self.cache[key])
            return self.cache[key].val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache.keys():
            self.remove(self.cache[key])
        self.cache[key] = Node(key, value)
        self.insert(self.cache[key])

        if len(self.cache) > self.cap:
            # evict LRU and swap
            lru = self.left.next
            self.remove(lru)
            del self.cache[lru.key]

if __name__ == '__main__':
    pass
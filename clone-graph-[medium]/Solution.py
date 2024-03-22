"""
# Definition for a Node.
"""
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:

        map = {}

        def dfs():
            pass

        return res

if __name__ == '__main__':
    s = Solution()
    print(s.cloneGraph([[2,4],[1,3],[2,4],[1,3]]))
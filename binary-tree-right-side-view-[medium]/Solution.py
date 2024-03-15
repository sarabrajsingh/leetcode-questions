from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rightSideView(self, root):
        
        q = deque([root])
        res = []

        while q:
            right = None
            q_len = len(q)

            for i in range(q_len):
                node = q.popleft()
                if node: # null check
                    right = node
                    q.append(node.left)
                    q.append(node.right)
            if right:
                res.append(right.val)

        return res



if __name__ == '__main__':

    root = TreeNode(val=1)
    root.left = TreeNode(val=2)
    root.left.right = TreeNode(val=5)
    
    root.right = TreeNode(val=3)
    root.right.right = TreeNode(val=4)

    s = Solution()

    print(s.rightSideView(root))
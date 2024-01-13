- any inorder traversal of a BST will result in an ordered output
- ie

        3
       / \
      1   4
       \
        2

- will give us [1,2,3,4] when searched inorder
- keep adding root.left to a stack until root.left == null
- pop() the last left node, add it's value to an array, then add the right node, pop(), repeat value adding for right node and then continue popping

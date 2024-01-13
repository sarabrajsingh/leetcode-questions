import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(kthSmallest(root, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            // go depth first on lhs to add to stack
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);

            if (res.size() == k)
                break;

            root = root.right;
        }

        return res.get(k - 1);
    }
}
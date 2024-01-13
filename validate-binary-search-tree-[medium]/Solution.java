import java.util.Stack;

class Solution {

    public static void main(String[] args) {

        // [5,4,6,null,null,3,7]

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MIN_VALUE;

        stack.push(root);

        while (!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= min) {
                return false;
            }

            min = root.val;
            root = root.right;
        }

        return true;
    }
}
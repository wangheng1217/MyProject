package wangheng.lintcode;

import java.util.Stack;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class MaxTreeSolution {
    /**
     * @param A
     *            : Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i <= A.length; i++) {
            if (i < A.length && (stack.empty() || A[i] < stack.peek().val)) {
                stack.push(new TreeNode(A[i]));
            } else {
                TreeNode node = stack.pop();
                while (!stack.empty() && (i == A.length || stack.peek().val < A[i])) {
                    stack.peek().right = node;
                    node = stack.pop();
                }

                if (i == A.length) {
                    stack.push(node);
                } else {
                    TreeNode root = new TreeNode(A[i]);
                    root.left = node;
                    stack.push(root);
                }
            }
        }

        return stack.empty() ? null : stack.pop();
    }
}

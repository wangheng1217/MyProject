package wangheng.leetcode;

import java.util.Stack;

public class PathSumSolution {
    public boolean hasPathSum4(TreeNode root, int sum) {
        Stack<TreeNodeSum> stack = new Stack<TreeNodeSum>();
        stack.push(new TreeNodeSum(root, sum));
        while (!stack.isEmpty()) {
            TreeNodeSum nodeSum = stack.pop();
            if (nodeSum.node != null) {
                if (nodeSum.node.left == null && nodeSum.node.right == null && nodeSum.node.val == nodeSum.sum) return true;
                stack.push(new TreeNodeSum(nodeSum.node.left, nodeSum.sum-nodeSum.node.val));
                stack.push(new TreeNodeSum(nodeSum.node.right, nodeSum.sum-nodeSum.node.val));
            }
        }
        return false;
    }
    
    private class TreeNodeSum {
        TreeNode node;
        int sum;
        TreeNodeSum(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum3(root.left, sum-root.val) || hasPathSum3(root.right, sum-root.val);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && sum == root.val)
            return true;
        if (root.left != null && hasPathSum(root.left, sum - root.val))
            return true;
        if (root.right != null && hasPathSum(root.right, sum - root.val))
            return true;
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        else
            return hasPathSum2(root.left, sum - root.val)
                    || hasPathSum2(root.right, sum - root.val);
    }
}

package wangheng.leetcode;

import java.util.Stack;

public class BinarySearchTreeIteratorSolution {

}

class BSTIterator {
    
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        
        return result;
    }
}

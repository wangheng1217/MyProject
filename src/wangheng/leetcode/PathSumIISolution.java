package wangheng.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumIISolution {
    public List<List<Integer>> pathSum4(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNodeSum> stack = new Stack<TreeNodeSum>();
        
        TreeNodeSum nodeSum = new TreeNodeSum(root, sum);
        stack.push(nodeSum);
        stack.push(nodeSum);
        
        while (!stack.isEmpty()) {
            nodeSum = stack.pop();
            if (!stack.isEmpty() && nodeSum == stack.peek()) {
                list.add(nodeSum.node.val);
                if (nodeSum.node.left == null && nodeSum.node.right == null && nodeSum.node.val == nodeSum.sum) {
                    result.add(new ArrayList<Integer>(list));
                }
                
                if (nodeSum.node.left != null) {
                    TreeNodeSum leftNodeSum = new TreeNodeSum(nodeSum.node.left, nodeSum.sum-nodeSum.node.val);
                    stack.push(leftNodeSum);
                    stack.push(leftNodeSum);
                }
                
                if (nodeSum.node.right != null) {
                    TreeNodeSum rightNodeSum = new TreeNodeSum(nodeSum.node.right, nodeSum.sum-nodeSum.node.val);
                    stack.push(rightNodeSum);
                    stack.push(rightNodeSum);
                }
            } else {
                list.remove(list.size()-1);
            }
        }
        
        return result;
    }
    
    private class TreeNodeSum {
        TreeNode node;
        int sum;
        TreeNodeSum(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, sum, result, new ArrayList<Integer>());
        return result;
    }
    
    private void dfs(TreeNode node, int sum, List<List<Integer>> result, List<Integer> path) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                path.add(node.val);
                result.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(node.val);
        dfs(node.left, sum-node.val, result, path);
        dfs(node.right, sum-node.val, result, path);
        path.remove(path.size()-1);
    }
    
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> path = new ArrayList<Integer>();
                path.add(root.val);
                result.add(path);
            }
            return result;
        }
        List<List<Integer>> leftResult = pathSum2(root.left, sum-root.val);
        List<List<Integer>> rightResult = pathSum2(root.right, sum-root.val);
        result.addAll(leftResult);
        result.addAll(rightResult);
        for (List<Integer> path : result) {
            path.add(0, root.val);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        dfs(root, res, new ArrayList<Integer>(), sum);
        return res;
    }

    private void dfs(TreeNode node, ArrayList<ArrayList<Integer>> res,
            ArrayList<Integer> path, int sum) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                res.add((ArrayList<Integer>) path.clone());
            }
        } else {
            if (node.left != null) {
                dfs(node.left, res, path, sum - node.val);
            }

            if (node.right != null) {
                dfs(node.right, res, path, sum - node.val);
            }
        }
        path.remove(path.size() - 1);
    }

}

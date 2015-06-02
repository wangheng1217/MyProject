package wangheng.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewSolution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (root == null) return list;
        
        list.add(root.val);
        
        List<Integer> rightList = rightSideView(root.right);
        List<Integer> leftList = rightSideView(root.left);
        list.addAll(rightList);
        if (leftList.size() > rightList.size()) {
            list.addAll(leftList.subList(rightList.size(), leftList.size()));
        }
        
        return list;
    }
}

package wangheng.lintcode;

/**
 * Created by Heng Wang on 10/27/2015.
 */
public class BinaryTreeSerialization {
    private static final String NULL = "#";
    private static final String DELIMITER = " ";

    private int curr;

    public String serialize(TreeNode root) {
        if (root == null) return NULL;
        return new StringBuilder().append(root.val)
                .append(DELIMITER).append(serialize(root.left))
                .append(DELIMITER).append(serialize(root.right))
                .toString();
    }

    public TreeNode deserialize(String data) {
        String[] vals = data.split(DELIMITER);
        curr = 0;
        TreeNode root = buildNode(vals);
        return root;
    }

    private TreeNode buildNode(String[] vals) {
        String val = vals[curr++];
        if (NULL.equals(val)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildNode(vals);
        node.right = buildNode(vals);
        return node;
    }
}

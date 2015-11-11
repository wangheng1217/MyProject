package wangheng.lintcode;

public class IntervalSumIISolution {
    /* you may need to use some attributes here */
    
    Node root;

    /**
     * @param A: An integer array
     */
    public IntervalSumIISolution(int[] A) {
        if (A.length != 0) root = buildSegmentTree(0, A.length-1, A);
    }
    
    private Node buildSegmentTree(int start, int end, int[] A) {
        Node node = new Node(start, end);
        if (start == end) {
            node.sum = A[start];
        } else {
            node.left = buildSegmentTree(start, (start+end)/2, A);
            node.right = buildSegmentTree((start+end)/2+1, end, A);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        if (root == null) return 0L;
        return query(root, start, end);
    }
    
    private long query(Node node, int start, int end) {
        if (start <= node.start && end >= node.end) return node.sum;
        if (start > end || start > node.end || end < node.start) return 0L;
        return query(node.left, start, end) + query(node.right, start, end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modify(root, index, value);
    }
    
    private void modify(Node node, int index, int value) {
        if (index < node.start || index > node.end) return;
        if (node.start == node.end && node.start == index) node.sum = value;
        else {
            modify(node.left, index, value);
            modify(node.right, index, value);
            node.sum = node.left.sum + node.right.sum;
        }
    }
    
    class Node {
        int start, end;
        long sum;
        Node left, right;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
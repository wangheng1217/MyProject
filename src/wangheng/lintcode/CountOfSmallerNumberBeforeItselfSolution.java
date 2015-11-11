package wangheng.lintcode;

import java.util.ArrayList;

public class CountOfSmallerNumberBeforeItselfSolution {
    /**
      * @param A: An integer array
      * @return: Count the number of element before this element 'ai' is 
      *          smaller than it and return count number array
      */ 
    public ArrayList<Integer> countOfSmallerNumberII0(int[] A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) return result;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : A) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        Node root = buildSegmentTree(min, max);
        
        for (int num : A) {
            result.add(query(root, min, num-1));
            add(root, num);
        }
        
        return result;
    }

    Node buildSegmentTree(int min, int max) {
        Node root = new Node(min, max);
        if (min == max) return root;
        root.left = buildSegmentTree(min, (min+max)/2);
        root.right = buildSegmentTree((min+max)/2+1, max);
        return root;
    }

    int query(Node node, int min, int max) {
        if (min > max || node.end < min || node.start > max) return 0;
        if (node.start >= min && node.end <= max) return node.count;
        return query(node.left, min, max) + query(node.right, min, max);
    }

    void add(Node node, int num) {
        if (num < node.start || num > node.end) return;
        node.count++;
        if (node.start == node.end) return;
        add(node.left, num);
        add(node.right, num);
    }

    class Node {
        int start, end, count;
        Node left, right;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
     
     int lowbit(int n) {
         return n & (-n);
     }
     
     int sum(int[] c, int n) {
         int sum = 0;
         while (n > 0) {
             sum += c[n];
             n -= lowbit(n);
         }
         return sum;
     }
     
     void add(int[] c, int i, int x) {
         while (i < c.length) {
             c[i] += x;
             i += lowbit(i);
         }
     }
     
     public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
         // write your code here
         int[] c = new int[10001];
         ArrayList<Integer> result = new ArrayList<Integer>();
         for (int i = 0; i < A.length; ++i) {
             result.add(sum(c, A[i]));
             add(c, A[i] + 1, 1);
         }
         return result;
     }
}

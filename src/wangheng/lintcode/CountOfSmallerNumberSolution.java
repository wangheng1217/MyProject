package wangheng.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*

 Just loop - O(kn) 
 Sort and binary search - O(nlogn + klogn), n refers to the length of given integer array
 Build Segment Tree and Search. - O(n + klogn), n refers to the value range width of given integer array (the values are from 0 to 10000 in this question)

 ATTENTION: the n in the time complexity is different between binary search solution and segment tree solution.

 */
public class CountOfSmallerNumberSolution {
    /**
     * @param A
     *            : An integer array
     * @return: The number of element in the array that are smaller that the
     *          given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (queries.length == 0)
            return result;
        if (A.length == 0) {
            for (int i = 0; i < queries.length; i++)
                result.add(0);
            return result;
        }

        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int num : A) {
            Integer count = countMap.get(num);
            if (count == null)
                countMap.put(num, 1);
            else
                countMap.put(num, count + 1);
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        Node root = buildSegmentTree(minNum, maxNum, countMap);

        for (int query : queries) {
            result.add(findCount(root, minNum, query - 1));
        }

        return result;
    }

    private Node buildSegmentTree(int start, int end, Map<Integer, Integer> countMap) {
        Node root = new Node(start, end);
        if (start == end) {
            Integer count = countMap.get(start);
            root.count = (count == null ? 0 : count);
        } else {
            root.left = buildSegmentTree(start, (start + end) / 2, countMap);
            root.right = buildSegmentTree((start + end) / 2 + 1, end, countMap);
            root.count = root.left.count + root.right.count;
        }
        return root;
    }

    private int findCount(Node root, int start, int end) {
        if (start <= root.start && end >= root.end)
            return root.count;
        if (start > end || start > root.end || end < root.start)
            return 0;
        return findCount(root.left, start, end) + findCount(root.right, start, end);
    }
    
    /*
    Sort and binary search
    
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (queries.length == 0) return result;
        if (A.length == 0) {
            for (int i = 0; i < queries.length; i++) result.add(0);
            return result;
        }
        
        Arrays.sort(A);
        for (int query : queries) {
            result.add(findCount(A, query));
        }
        
        return result;
    }
    
    private int findCount(int[] array, int target) {
        int l = 0, r = array.length-1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (array[mid] < target) l = mid+1;
            else r = mid-1;
        }
        return l;
    }
     */

    class Node {
        int start, end, count;
        Node left, right;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

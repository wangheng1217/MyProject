package wangheng.leetcode;

public class MedianOfTwoSortedArraysSolution3 {
    public double findMedianSortedArrays(int A[], int B[]) {
        int length = A.length + B.length;
        if (length % 2 == 0) {
            return (findKthElement(A, 0, B, 0, length/2) + findKthElement(A, 0, B, 0, length/2+1)) / 2d;
        } else {
            return findKthElement(A, 0, B, 0, length/2+1);
        }
    }
    
    private int findKthElement(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart >= A.length) {
            return B[bStart+k-1];
        }
        if (bStart >= B.length) {
            return A[aStart+k-1];
        }
        
        if (k == 1) return Math.min(A[aStart], B[bStart]);
        
        int aKey = aStart+k/2-1 < A.length ? A[aStart+k/2-1] : Integer.MAX_VALUE;
        int bKey = bStart+k/2-1 < B.length ? B[bStart+k/2-1] : Integer.MAX_VALUE;
        
        if (aKey < bKey) {
            return findKthElement(A, aStart+k/2, B, bStart, k-k/2);
        } else {
            return findKthElement(A, aStart, B, bStart+k/2, k-k/2);
        }
    }
}

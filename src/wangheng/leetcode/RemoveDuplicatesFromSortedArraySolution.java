package wangheng.leetcode;

public class RemoveDuplicatesFromSortedArraySolution {
    public int removeDuplicates3(int[] A) {
        int l = 0;
        for (int i = 0; i < A.length; i++) {
            if (l == 0 || A[i] != A[l-1]) A[l++] = A[i];
        }
        return l;
    }

    public int removeDuplicates2(int[] A) {
        int i = 0;
        int j = 0;
        while (j < A.length) {
            int value = A[i];
            i++;
            j++;
            while (j < A.length) {
                if (A[j] == value) {
                    j++;
                }
                else {
                    break;
                }
            }
            if (j < A.length) {
                swap(A, i, j);
            }
        }
        return i;
    }
    
    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public int removeDuplicates(int[] A) {
        if(A.length < 2) return A.length;
        int i = 0;
        for(int j = 1; j < A.length; j++) {
            if(A[j] == A[i]) {
                continue;
            }
            else {
                i++;
                A[i] = A[j];
            }
        }
        return i+1;
    }

}

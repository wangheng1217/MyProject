package wangheng.leetcode;

public class RemoveDuplicatesFromSortedArrayIISolution {
    public int removeDuplicates2(int[] A) {
        int l = 0;
        for (int i = 0; i < A.length; i++) {
            if (l == 0 || l == 1 || A[i] != A[l-2]) A[l++] = A[i];
        }
        return l;
    }

    public int removeDuplicates(int[] A) {
        if (A.length < 2)
            return A.length;
        int i = 0;
        int count = 0;
        for (int j = 1; j < A.length; j++) {
            if (A[i] == A[j]) {
                if (count == 0) {
                    count = 1;
                    i++;
                    A[i] = A[j];
                } else {
                    continue;
                }
            } else {
                count = 0;
                i++;
                A[i] = A[j];
            }
        }
        return i + 1;
    }

}

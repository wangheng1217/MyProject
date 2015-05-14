package wangheng.sorting;

public class MergeSort extends AbstractSort {

    public static void main(String[] args) {
        MergeSort s = new MergeSort();
        int[] input = { 1, 10, 2, 6, 8, 4, 7, 5, 3, 9 };
        int[] output = s.sort(input);
        print(input);
        print(output);
    }

    @Override
    public int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(int[] array, int begin, int end) {
        if (begin == end) {
            return;
        }
        int mid = (begin + end) / 2;
        sort(array, begin, mid);
        sort(array, mid + 1, end);
        merge(array, begin, mid, end);
    }
    
    private void merge(int[] array, int begin, int mid, int end) {
        int[] mergedArray = new int[end-begin+1];
        int p1 = begin, p2 = mid+1;
        for (int i = 0; i < mergedArray.length; i++) {
            if (p2 > end || (p1 <= mid && array[p1] <= array[p2])) {
                mergedArray[i] = array[p1++];
            } else {
                mergedArray[i] = array[p2++];
            }
        }
        
        for (int i = 0; i < mergedArray.length; i++) {
            array[begin+i] = mergedArray[i];
        }
    }

}

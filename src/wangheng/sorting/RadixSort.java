package wangheng.sorting;

public class RadixSort extends AbstractSort{

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        print(new RadixSort().sort(array));
    }

    @Override
    public int[] sort(int[] array) {
        for (int exp = 1; exp <= 100; exp = exp*10) {
            countSort(array, exp);
        }
        return array;
    }
    
    private void countSort(int[] array, int exp) {
        int[] count = new int[10];
        
        for (int i = 0; i < array.length; i++) {
            count[(array[i]/exp)%10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i-1];
        }
        
        int[] result = new int[array.length];
        for (int i = array.length-1; i >= 0; i--) {
            result[count[(array[i]/exp)%10] - 1] = array[i];
            count[(array[i]/exp)%10]--;
        }
        
        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

}

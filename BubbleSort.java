public class BubbleSort {

    protected void sortArray(int[] a) {
        int n = a.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swapped = true;
                }
            }
            
            if (!swapped)
                break;
        }
    }

    public static void main(String args[]) {
        BubbleSort sp = new BubbleSort();
        int[] array = {7, 6, 5, 4, 3, 2, 1};
        Util.printArray(array);
        sp.sortArray(array);
        Util.printArray(array);
    }
}
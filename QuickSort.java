public class QuickSort {

    protected void sort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partitionArray(array, start, end);
            sort(array, 0, pivotIndex - 1);
            sort(array, pivotIndex + 1, end);
        }
    }

    private int partitionArray(int[] a, int start, int end) {
        int pivot = a[end];
        int pivotIndex = 0;
        for (int i = 0; i < end; i++) {
            if (a[i] <= pivot) {
                //swap a[i] and a[pivotIndex]
                int t = a[i];
                a[i] = a[pivotIndex];
                a[pivotIndex] = t;
                pivotIndex++;
            }
        }
        //swap pivot and a[pivotIndex]
        int t = pivot;
        a[end] = a[pivotIndex];
        a[pivotIndex] = t;

        return pivotIndex;
    }

    public static void main(String args[]) {
        int[] array = {4, 6, 2, 7, 8, 5, 1, 3};
        Util.printArray(array);

        QuickSort sp = new QuickSort();
        sp.sort(array, 0, array.length - 1);
        Util.printArray(array);
    }
}
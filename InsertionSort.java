public class InsertionSort {

    protected void sortArray(int a[]) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int val = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > val) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = val;
        }
    }

    public static void main(String args[]) {
        int a[] = {5, 1, 4, 8, 3, 0, -2};
        Util.printArray(a);

        InsertionSort sp = new InsertionSort();
        sp.sortArray(a);
        Util.printArray(a);
    }
}
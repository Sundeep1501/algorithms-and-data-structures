public class SelectionSort {

    protected void printArray(int array[]) {
        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    protected void sortArray(int a[]) {
        int n = a.length;
        for (int p = 0; p < n - 1; p++) {
            int min = p;
            for (int i = p + 1; i < n; i++) {
                if (a[i] < a[min])
                    min = i;
            }

            // swap least item with position
            int t = a[p];
            a[p] = a[min];
            a[min] = t;
        }
    }

    public static void main(String[] args) {
        SelectionSort sp = new SelectionSort();
        int[] array = {1, 6, 2, 0, -1, 5, 3};
        sp.printArray(array);
        sp.sortArray(array);
        sp.printArray(array);
    }

}
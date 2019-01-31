public class MergeSort {

    // merge two sorted arrays in to one array.
    private int[] merge2Arrays(int[] left, int[] right, int[] array) {
        int leftLength = left.length;
        int rightLength = right.length;

        int arrayIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        // set each small number from left and right list to array

        // loop till either one of the lists has no items.
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] <= right[rightIndex]) {
                array[arrayIndex] = left[leftIndex];
                leftIndex++;
            } else {
                array[arrayIndex] = right[rightIndex];
                rightIndex++;
            }
            arrayIndex++;
        }

        // set remaining left items one by one in to array
        while (leftIndex < leftLength) {
            array[arrayIndex] = left[leftIndex];
            leftIndex++;
            arrayIndex++;
        }

        // set remaining right items one by one in to array
        while (rightIndex < rightLength) {
            array[arrayIndex] = right[rightIndex];
            rightIndex++;
            arrayIndex++;
        }

        return array;
    }

    protected int[] sort(int[] array) {

        int arrayLength = array.length;

        // already sorted
        if (arrayLength < 2) {
            return array;
        }

        int leftArrayLength = arrayLength / 2;
        int rightArrayLength = arrayLength - leftArrayLength;

        int arrayIndex = 0;
        int[] leftArray = new int[leftArrayLength];

        while (arrayIndex < leftArrayLength) {
            leftArray[arrayIndex] = array[arrayIndex];
            arrayIndex++;
        }

        int[] rightArray = new int[rightArrayLength];
        while (arrayIndex < arrayLength) {
            rightArray[arrayIndex - leftArrayLength] = array[arrayIndex];
            arrayIndex++;
        }

        return merge2Arrays(sort(leftArray), sort(rightArray), array);
    }

    public static void main(String args[]) {
        MergeSort sp = new MergeSort();

        int[] array = {0, 9, 8, 7, 6, 5, 1, 2, 3, 4};
        Util.printArray(array);


        Util.printArray(sp.sort(array));
    }

}
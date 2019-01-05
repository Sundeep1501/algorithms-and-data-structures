public class SpiralMatrix {

    public int[] spiralOrder(final int[][] matrix) {
        // no of elements
        int n = matrix[0].length * matrix.length;
        int[] result = new int[n];
        int rI = 0;

        // left index, right index, bottom index, top index
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;

        //order t,r,b,l

        while (rI < n) {
            // top row
            int[] top = matrix[t];
            for (int i = l; i <= r; i++) {
                result[rI++] = top[i];
            }
            t++;

            if (n == rI) {
                break;
            }

            // right column
            for (int i = t; i <= b; i++) {
                int[] row = matrix[i];
                result[rI++] = row[r];
            }
            r--;

            if (n == rI) {
                break;
            }

            // bottom row
            int[] bottom = matrix[b];
            for (int i = r; i >= l; i--) {
                result[rI++] = bottom[i];
            }
            b--;


            if (n == rI) {
                break;
            }
            // left column
            for (int i = b; i >= t; i--) {
                int[] row = matrix[i];
                result[rI++] = row[l];
            }
            l++;

        }
        return result;
    }

    public static void main(String args[]) {
        int[][] matrix = new int[][] {
            {1, 2, 3},
            {1, 2, 4},
            {1, 2, 5}
        };

        SpiralMatrix sp = new SpiralMatrix();

        for (int i: sp.spiralOrder(matrix)) {
            System.out.print(i + ", ");
        }
    }
}

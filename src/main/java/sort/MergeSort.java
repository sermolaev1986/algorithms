package sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MergeSort {
    public static void main(String[] args) {
        assertThat(sort(new int[]{6, 4, 1, 9, 20, 0, 3}), is(new int[]{0, 1, 3, 4, 6, 9, 20}));
        assertThat(sort(new int[]{30000, -3, 6, 454311, 999, 0}), is(new int[]{-3, 0, 6, 999, 30000, 454311}));
    }

    private static int[] sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
        return a;
    }

    private static void mergeSort(int[] a, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            //find the middle
            int middle = (lowerIndex + higherIndex) / 2;

            //sort first and second halves
            mergeSort(a, lowerIndex, middle);
            mergeSort(a, middle + 1, higherIndex);

            //merge sorted halves
            merge(a, lowerIndex, middle, higherIndex);
        }
    }

    private static void merge(int[] a, int lowerIndex, int middle, int higherIndex) {
        //find sizes of two halves to be merged
        int n1 = middle - lowerIndex + 1;
        int n2 = higherIndex - middle;

        //create temp arrays
        int[] l = new int[n1];
        int[] r = new int[n2];

        //copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            l[i] = a[lowerIndex + i];
        }

        for (int i = 0; i < n2; i++) {
            r[i] = a[middle + 1 + i];
        }

        //merge temp arrays
        int i1 = 0, i2 = 0;
        int k = lowerIndex;
        while (i1 < n1 && i2 < n2) {
            if (l[i1] <= r[i2]) {
                a[k] = l[i1];
                i1++;
            } else {
                a[k] = r[i2];
                i2++;
            }
            k++;
        }

        //copy remaining elements from left array if any
        while (i1 < n1) {
            a[k] = l[i1];
            i1++;
            k++;
        }

        //copy remaining elements from right array if any
        while (i2 < n2) {
            a[k] = r[i2];
            i2++;
            k++;
        }
    }
}

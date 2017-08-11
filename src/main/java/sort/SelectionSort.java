package sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectionSort {

    public static void main(String[] args) {
        assertThat(sort(new int[]{6, 4, 1, 9, 20, 0, 3}), is(new int[]{0, 1, 3, 4, 6, 9, 20}));
        assertThat(sort(new int[]{30000, -3, 6, 454311, 999, 0}), is(new int[]{-3, 0, 6, 999, 30000, 454311}));
    }

    private static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            //find next min
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            //swap next min with current boundary
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }

        }

        return a;
    }
}

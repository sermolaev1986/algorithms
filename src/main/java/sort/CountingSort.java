package sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CountingSort {
    public static void main(String[] args) {
        assertThat(sort(new int[]{6, 4, 1, 9, 20, 0, 3}), is(new int[]{0, 1, 3, 4, 6, 9, 20}));
        assertThat(sort(new int[]{30000, 3, 6, 454311, 999, 0}), is(new int[]{0, 3, 6, 999, 30000, 454311}));
    }

    private static int[] sort(int[] a) {
        int[] runningSums = new int[Integer.MAX_VALUE - 3];
        int[] result = new int[a.length];

        //count elements
        for (int i = 0; i < a.length; i++) {
            runningSums[a[i]]++;
        }

        //calculate running sums
        for (int i = 1; i < runningSums.length; i++) {
            runningSums[i] += runningSums[i - 1];
        }

        //build sorted array based on count of elements which are smaller than current
        for (int i = 0; i < a.length; i++) {
            result[runningSums[a[i]] - 1] = a[i];
            runningSums[a[i]]--;
        }

        return result;
    }
}

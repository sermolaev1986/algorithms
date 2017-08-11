package sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InsertionSort {

    public static void main(String[] args) {
        assertThat(sort(new int[]{6, 4, 1, 9, 20, 0, 3}), is(new int[]{0, 1, 3, 4, 6, 9, 20}));
        assertThat(sort(new int[]{30000, -3, 6, 454311, 999, 0}), is(new int[]{-3, 0, 6, 999, 30000, 454311}));
    }

    private static int[] sort(int[] a) {

        int temp;
        for (int i = 0; i < a.length; i++) {
            //take element next to boundary and insert into proper location
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
        return a;
    }
}

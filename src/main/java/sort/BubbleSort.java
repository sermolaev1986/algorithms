package sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BubbleSort {

    public static void main(String[] args) {
        assertThat(sort(new int[]{6, 4, 1, 9, 20, 0, 3}), is(new int[]{0, 1, 3, 4, 6, 9, 20}));
        assertThat(sort(new int[]{30000, -3, 6, 454311, 999, 0}), is(new int[]{-3, 0, 6, 999, 30000, 454311}));
    }

    private static int[] sort(int[] a) {

        int temp;
        //set the flag to being first pass
        boolean isBubbling = true;

        while (isBubbling) {
            //set to false awaiting a possible swap
            isBubbling = false;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    //swap occurred
                    isBubbling = true;
                }
            }
        }

        return a;
    }
}

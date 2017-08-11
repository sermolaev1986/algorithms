package sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HeapSort {
    public static void main(String[] args) {
        assertThat(sort(new int[]{6, 4, 1, 9, 20, 0, 3}), is(new int[]{0, 1, 3, 4, 6, 9, 20}));
        assertThat(sort(new int[]{30000, -3, 6, 454311, 999, 0}), is(new int[]{-3, 0, 6, 999, 30000, 454311}));
    }

    private static int[] sort(int[] a) {
        buildHeap(a);

        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            siftDown(a, 0, i);
        }

        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void buildHeap(int[] a) {
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            siftDown(a, i, a.length - 1);
        }
    }

    private static void siftDown(int[] a, int parent, int heapSize) {
        int leftChild = parent * 2 + 1;
        int rightChild = leftChild + 1;
        int maxIndex = parent;

        if (rightChild < heapSize && a[rightChild] > a[parent]) {
            maxIndex = rightChild;
        }

        if (leftChild < heapSize && a[leftChild] > a[maxIndex]) {
            maxIndex = leftChild;
        }

        if (maxIndex != parent) {
            //sift parent down
            swap(a, maxIndex, parent);
            siftDown(a, maxIndex, heapSize);
        }
    }
}

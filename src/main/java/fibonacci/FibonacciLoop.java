package fibonacci;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciLoop {

    public static void main(String[] args) {
        assertThat(fibonacci(0), is(1));
        assertThat(fibonacci(1), is(1));
        assertThat(fibonacci(2), is(2));
        assertThat(fibonacci(3), is(3));
        assertThat(fibonacci(4), is(5));
        assertThat(fibonacci(5), is(8));
        assertThat(fibonacci(6), is(13));
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev = 1;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current;
            current += prev;
            prev = temp;
        }

        return current;
    }
}

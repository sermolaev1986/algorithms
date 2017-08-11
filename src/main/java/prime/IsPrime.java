package prime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IsPrime {

    public static void main(String[] args) {
        assertThat(isPrime(3), is(true));
        assertThat(isPrime(4), is(false));
        assertThat(isPrime(5), is(true));
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

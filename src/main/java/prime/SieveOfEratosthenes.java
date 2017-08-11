package prime;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        assertThat(sieve(1), is(new boolean[]{false, false}));
        assertThat(sieve(2), is(new boolean[]{false, false, true}));
        assertThat(sieve(3), is(new boolean[]{false, false, true, true}));
        assertThat(sieve(4), is(new boolean[]{false, false, true, true, false}));
        assertThat(sieve(5), is(new boolean[]{false, false, true, true, false, true}));
    }

    private static boolean[] sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }

        return sieve;
    }
}

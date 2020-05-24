package lab_1;

import junit.framework.TestCase;

import java.math.BigInteger;
import java.security.SecureRandom;

public class FermatTestTest extends TestCase {
    private final SecureRandom random = new SecureRandom();
    private final int iteration = 100;

    public void testIsPrime() {
        final int bitLength = 512;

        for (int i = 0; i < iteration; ++i) {
            final BigInteger prime_number = BigInteger.probablePrime(bitLength, random);
            final BigInteger no_prime_number = prime_number.add(BigInteger.ONE);

            assertTrue(FermatTest.isPrime(prime_number, random));
            assertFalse(FermatTest.isPrime(no_prime_number, random));
        }
    }
}
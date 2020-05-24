package lab_1;

import junit.framework.TestCase;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabinTestTest extends TestCase {
    private final SecureRandom random = new SecureRandom();

    public void testIsPrime() {
        final int bitLength = 512;

        int iteration = 100;
        for (int i = 0; i < iteration; ++i) {
            final BigInteger prime_number = BigInteger.probablePrime(bitLength, random);
            final BigInteger no_prime_number = prime_number.add(BigInteger.ONE);

            assertTrue(MillerRabinTest.isPrime(prime_number, random));
            assertFalse(MillerRabinTest.isPrime(no_prime_number, random));
        }
    }
}
package lab_1;

import junit.framework.TestCase;

import java.math.BigInteger;
import java.security.SecureRandom;

public class KaratsubaMultiplicationTest extends TestCase {
    private final SecureRandom random = new SecureRandom();


    public void testMultiply() {
        final int bitLength = 512;

        int iteration = 100;
        for (int i = 0; i < iteration; ++i) {
            final BigInteger firstNumber = BigInteger.probablePrime(bitLength, random);
            final BigInteger SecondNumber = BigInteger.probablePrime(bitLength, random);

            final BigInteger expected = firstNumber.multiply(SecondNumber);
            final BigInteger actual = KaratsubaMultiplication.Multiply(firstNumber, SecondNumber);

            assertEquals(expected, actual);
        }
    }
}
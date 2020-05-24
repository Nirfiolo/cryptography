package lab_1;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class Main {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        final int bitLength = 512;

        final BigInteger first_number = new BigInteger(bitLength, random);
        final BigInteger second_number = BigInteger.probablePrime(bitLength, random);

        System.out.println(first_number);
        System.out.print("Is prime: ");
        System.out.print(FermatTest.isPrime(first_number, random));
        System.out.println();

        System.out.println(second_number);
        System.out.print("Is prime: ");
        System.out.print(FermatTest.isPrime(second_number, random));
    }
}

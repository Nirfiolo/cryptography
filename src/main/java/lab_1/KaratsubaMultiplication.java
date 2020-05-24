package lab_1;

import java.math.BigInteger;

public class KaratsubaMultiplication {
    private KaratsubaMultiplication() {

    }

    static public BigInteger Multiply(final BigInteger first, final BigInteger second) {
        if (isSingleValue(first) && isSingleValue(second)) {
            return first.multiply(second);
        }

        final int firstDigitsCount = first.toString().length();
        final int secondDigitsCount = second.toString().length();

        final BigInteger firstTenInPower = BigInteger.valueOf((long) Math.pow(10.0, (double) (firstDigitsCount / 2)));
        final BigInteger firstHalfOfFirst = first.divide(firstTenInPower);
        final BigInteger secondHalfOfFirst = first.mod(firstTenInPower);

        final BigInteger secondTenInPower = BigInteger.valueOf((long) Math.pow(10.0, (double) (secondDigitsCount / 2)));
        final BigInteger firstHalfOfSecond = second.divide(secondTenInPower);
        final BigInteger secondHalfOfSecond = second.mod(secondTenInPower);

        final BigInteger a = Multiply(firstHalfOfFirst, firstHalfOfSecond);
        final BigInteger d = Multiply(secondHalfOfFirst, secondHalfOfSecond);

        final BigInteger e =
                Multiply(firstHalfOfFirst.add(secondHalfOfFirst), firstHalfOfSecond.add(secondHalfOfSecond))
                .subtract(a).subtract(d);

        final BigInteger aResult = a.multiply(BigInteger.valueOf((long) Math.pow(10.0, (double) (firstDigitsCount))));
        final BigInteger eResult = e.multiply(firstTenInPower);

        return aResult.add(eResult).add(d);
    }

    static private boolean isSingleValue(BigInteger number) {
        if (number.toString().length() == 1) {
            return true;
        }
        return false;
    }
}

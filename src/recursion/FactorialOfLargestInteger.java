package recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialOfLargestInteger {
    private static BigInteger calculateFactorial(BigInteger number) {
        if (number.equals(BigInteger.ONE) || number.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return number.multiply(calculateFactorial(number.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any positive integer: ");
        BigInteger number = scanner.nextBigInteger();
        scanner.close();
        if (number.compareTo(BigInteger.ZERO) < 0) {
            System.err.println("Please enter a positive integer next time!");
        } else {
            final BigInteger factorial = calculateFactorial(number);
            System.out.println("Factorial(" + number + ") = " + factorial);
            System.out.println("Fun Fact!: this factorial number has " + factorial.toString().length() + " digits!");
        }
    }
}

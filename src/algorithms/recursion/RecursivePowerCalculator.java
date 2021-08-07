package algorithms.recursion;

import java.util.Scanner;

public class RecursivePowerCalculator {
    private static int calculate(int base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        return base * calculate(base, exponent - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the base: ");
        int base = scanner.nextInt();
        System.out.println("Please enter the exponent: ");
        int exponent = scanner.nextInt();
        scanner.close();
        if (base < 0 || exponent < 0) {
            System.err.println("The base and the exponent must be positive!");
        } else {
            System.out.println(base + "^" + exponent + " = " + calculate(base, exponent));
        }
    }
}

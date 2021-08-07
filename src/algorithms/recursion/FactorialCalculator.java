package algorithms.recursion;

import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a positive integer: ");
        int number = scanner.nextInt();
        scanner.close();
        if (number < 0) {
            System.err.println("Please input a positive integer next time!");
        } else {
            System.out.println("Factorial(" + number + ") = " + calculateFactorial(number));
        }
    }
    private static int calculateFactorial(int number) {
        if (number == 1 || number == 0) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }
}

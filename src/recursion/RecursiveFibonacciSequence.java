package recursion;

import java.util.Scanner;

public class RecursiveFibonacciSequence {
    private static int findFibonacciTerm(int index) {
        if (index == 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        return findFibonacciTerm(index - 1) + findFibonacciTerm(index - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of terms you want in your fibonacci sequence: ");
        int numberOfTerms = scanner.nextInt();
        scanner.close();
        for (int i = 0; i < numberOfTerms; i++) {
            System.out.print(findFibonacciTerm(i) + ((i < numberOfTerms - 1) ? ", " : "."));
        }
    }
}

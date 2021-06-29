package recursion;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RecursiveArraySearch {
    private final int[] array;

    public RecursiveArraySearch(int size) {
        this.array = new int[size];
        fillArray();
        Arrays.sort(this.array);
        System.out.println("this.array = " + Arrays.toString(this.array));
    }

    private void fillArray() {
        for (int index = 0, size = this.array.length; index < size; index++) {
            this.array[index] = new Random().nextInt() % 100;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private int searchRecursively(int value, int startIndex) {
        if (array == null || startIndex < 0 || startIndex >= array.length) {
            return -1;
        } else if (array[startIndex] == value) {
            return startIndex;
        }
        return searchRecursively(value, startIndex + 1);
    }

    private int binarySearch(int value, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        if (value == this.array[middleIndex]) {
            return middleIndex;
        } else if (value < this.array[middleIndex]) {
            return binarySearch(value, startIndex, middleIndex - 1);
        } else {
            return binarySearch(value, middleIndex + 1, endIndex);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the size of the array: ");
        int sizeOfArray = scanner.nextInt();
        if (sizeOfArray < 0) {
            System.err.println("Please enter a positive size for the array!");
        } else {
            RecursiveArraySearch search = new RecursiveArraySearch(sizeOfArray);
            System.out.println("Please enter the number to search for: ");
            int number = scanner.nextInt();
            int foundIndex = search.searchRecursively(number, 0);
            if (foundIndex != -1) {
                System.out.println(number + " found at index " + foundIndex);
            } else {
                System.err.println(number + " not found in the array!");
            }
        }
        scanner.close();
    }
}

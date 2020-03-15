//Write a program to check a sorted array of various ints
// contains a fixed point. The array is sorted in the ascending order.
//
//        A fixed point is an index i such A[i] = i.
//
//        The integers in the array can be negative.
//        The input array doesn't contain duplicates.
//
//        Use binary search to solve the problem.
//
//        Input data format
//
//        The first line contains a number of elements in the array,
//        the second one consists of the elements.
//
//        Output data format
//
//        The program should output "true" or "false".
//        Sample Input 1:
//
//        5
//        -8 -2 0 3 9
//        Sample Output 1:
//
//        true

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int[] array = new int[arraySize];
        int i = 0;
        while (i < arraySize) {
            array[i] = sc.nextInt();
            i++;
        }
        System.out.println(binarySearch(array, 0, array.length - 1));
    }

    private static boolean binarySearch(final int[] array,
                                        final int left, final int right) {
        if (left > right) {
            return false;
        }
        int i = left + (right - left) / 2;
        if (i == array[i]) {
            return true;
        } else if (i < array[i]) {
            return binarySearch(array, left, i - 1);
        } else {
            return binarySearch(array, i + 1, right);
        }
    }
}

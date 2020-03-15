//For different arrays, Selection sort performs
// a different number of operations.
// Write a program that for a collection of arrays
// finds the one for which Selection sort
// makes the maximum number of operations.
//
//        Input: the first line contains two numbers nn and mm.
//        Each of the following nn lines contains an array:
//        mm numbers separates by spaces.
//
//        Output: the number of an array for which Selection sort
//        performs the maximum number of operations among all other arrays.
//        Assume that each array needs to be sorted in ascending order.
//        Here, an operation is either a changing of
//        the current minimum or exchanging
//        the current minimum with the current index.
//        If there are several arrays requiring
//        the maximum number of operations,
//        print the number of the first one.
//
//        Sample Input 1:
//
//        2 5
//        1 2 3 4 5
//        5 3 1 2 4
//        Sample Output 1:
//
//        2

import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfArrays = sc.nextInt();
        int size = sc.nextInt();
        int[][] array = new int[numOfArrays][size];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        Map<Integer, Integer> numOfStepsCollection = new TreeMap<>();

        for (int k = 0; k < numOfArrays; k++) {
            int[] currentArrayToSort = array[k];
            int numOfArray = k + 1;
            int steps = countStepsToSortArray(currentArrayToSort);
            numOfStepsCollection.put(numOfArray, steps);
        }

        System.out.println(
                Collections
                        .max(numOfStepsCollection.entrySet(),
                                Comparator.comparingInt(Map.Entry::getValue))
                        .getKey()
        );
    }

    private static int countStepsToSortArray(final int[] array) {
        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                    count++;
                }
            }

            int min = array[index];
            array[index] = array[i];
            array[i] = min;
        }

        return count;
    }
}


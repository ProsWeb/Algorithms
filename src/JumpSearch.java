//If you have an array of size NN,
// how many comparisons do you need to perform
// to find each element of this array using jump search?
//
//        Given a number NN, you should output NN numbers -
//        a number of comparisons you need to perform
//        if the element you search for happens to be on this place.
//
//        Sample Input 1:
//
//        11
//        Sample Output 1:
//
//        1 4 3 2 5 4 3 6 5 4 5

import java.util.Arrays;
import java.util.Scanner;

public class JumpSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int jumpSize = (int) Math.sqrt(arraySize);

        int[] result = comparisons(arraySize, jumpSize);
        Arrays.stream(result).forEach(n -> System.out.print(n + " "));
    }

    private static int[] comparisons(final int arraySize, final int jumpSize) {
        int[] comparisonNumbers = new int[arraySize];
        int lastFilledElement = 0;

        for (int i = 0, j = 1; i < arraySize; i += jumpSize, j++) {

            comparisonNumbers[i] = j;
            lastFilledElement = comparisonNumbers[i];

            if (i > 0) {
                for (int stepBackward = 1, numToFill = lastFilledElement + 1;
                     stepBackward < jumpSize; stepBackward++, numToFill++) {
                    comparisonNumbers[i - stepBackward] = numToFill;
                }
            }
        }

        if (comparisonNumbers[arraySize - 1] == 0) {
            int i = arraySize - 1;
            int j = 1;
            while (comparisonNumbers[i] == 0) {
                comparisonNumbers[i] = lastFilledElement + j;
                j++;
                i--;
            }
        }
        return comparisonNumbers;
    }
}

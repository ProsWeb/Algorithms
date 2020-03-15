//For a given array, using Bubble sorting,
// count the number of swaps (exchanges of two numbers)
// you need to do to fully sort the array
// in the ascending order. You need to output the number of swaps.
//        Sample Input 1:
//
//        2 1 3 4 5
//        Sample Output 1:
//
//        1
//        Sample Input 2:
//
//        8 3 4 6 5 2 1
//        Sample Output 2:
//
//        16

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();
        while (scanner.hasNext()) {
            array.add(scanner.nextInt());
        }
        System.out.println(bubbleSort(array));
    }

    private static int bubbleSort(final List<Integer> array) {
        int count = 0;
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    count++;
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }

        return count;
    }
}

//Given two strings of equal length (denoted as ss and tt) and an integer kk.
// Write a program that finds the index ii such that
// the Hamming distance between reverse(s[i:k])reverse(s[i:k]) and t[i:k]t[i:k] is the minimal.
//
//        Input: Two strings of equal length and an integer kk.
//
//        Output: Two numbers: the first is the index ii satisfying the conditions above,
//        the second is the Hamming distance between corresponding substrings.
//        If there are several such indexes, print the minimal one.
//
//        Sample Input 1:
//
//        123456789
//        654654654
//        3
//        Sample Output 1:
//
//        3 0
//        Sample Input 2:
//
//        111001
//        011000
//        4
//        Sample Output 2:
//
//        0 1

package algorithms.hamming_distance;

import java.util.*;

public class HammingDistanceReverseSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        int length = sc.nextInt();
        Map<Integer, Integer> map = indexAndDistance(first, second, length);
        System.out.print(minIndexAndDistance(map).getKey() + " "
                            + minIndexAndDistance(map).getValue());

    }
    private static String reverseSubstring(final String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return String.valueOf(reversed);
    }
    private static int hammingDistance(final String first,
                                       final String second) {
        int distance = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
    private static Map<Integer, Integer> indexAndDistance(final String first,
                                                          final String second,
                                                          final int length) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i <= first.length() - length; i++) {
            String reversedFirst = reverseSubstring(first.substring(i, length + i));
            String secondSubstring = second.substring(i, length + i);
            int distance = hammingDistance(reversedFirst, secondSubstring);
            map.put(i, distance);
        }
        return map;
    }
    private static Map.Entry<Integer, Integer> minIndexAndDistance(final Map<Integer, Integer> map) {
        Map.Entry<Integer, Integer> min = null;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (min == null || min.getValue() > m.getValue()) {
                min = m;
            }
        }
        return min;
    }
}

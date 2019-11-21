//Consider a collection of strings of equal length. Let's call a string a representative
// if it has the minimum sum of Hamming distances with all other strings from the collection.
// Write a program that finds a representative for a collection of strings of equal length.
//
//        Input: An integer k \gt 1k>1 and a collection of kk strings of equal length,
//        each is on a separate line.
//
//        Output: A representative of a given collection of strings.
//        If there are several representatives,
//        print the one that has the least index (assuming that the first string has an index 1,
//        the second string has an index 2 and so on).
//
//
//
//        Sample Input 1:
//
//        4
//        000000
//        010101
//        101010
//        001010
//        Sample Output 1:
//
//        000000
//        Sample Input 2:
//
//        4
//        aaabbb
//        ababab
//        bababa
//        abacab
//        Sample Output 2:
//
//        aaabbb

package algorithms.hamming.distance;

import java.util.*;

public class MinSumHammingDistances {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(scanner.nextLine());
        }
        Map<String, Integer> minSum = minimumHammingSum(list);
        // Map.Entry<String, Integer> min = null;
        // for (Map.Entry<String, Integer> entry : minSum.entrySet()) {
        //     if (min == null || min.getValue() > entry.getValue()) {
        //         min = entry;
        //     }
        // }
        Map.Entry<String, Integer> min = Collections.min(minSum.entrySet(),
                Comparator.comparing(Map.Entry::getValue));
        System.out.println(min.getKey());
    }
    private static Map<String, Integer> minimumHammingSum(final List<String> allStrings) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < allStrings.size(); i++) {
            String currentString = allStrings.get(i);
            List<String> restStrings = rest(allStrings, i);
            int distance = hammingDistance(restStrings, currentString);
            map.put(allStrings.get(i), distance);
        }
        return map;
    }
    private static List<String> rest(final List<String> allStrings,
                                     final int stringIndexToRemove) {
        List<String> restStrings = new ArrayList<>();
        for (int i = 0; i < allStrings.size(); i++) {
            if (i != stringIndexToRemove) {
                restStrings.add(allStrings.get(i));
            }
        }
        return restStrings;
    }

    private static int hammingDistance(final List<String> restStrings,
                                       final String pattern) {
        int distance = 0;
        for (String s : restStrings) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != pattern.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }
}

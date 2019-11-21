
//Given two strings, a pattern and a text. Write a program that finds a substring
// which has the minimum Hamming distance with the pattern.
//
//        Input: Two strings, a pattern and a text, each is on a separate line.
//        The length of the text is guaranteed to be no less when the length of the pattern.
//
//        Output: Two numbers: the first is the index of an occurrence of the pattern,
//        the second is the Hamming distance between the pattern and a substring which starts
//        from the found index. If there are several substrings with the minimum Hamming distance
//        with the pattern, print the index of the first one.
//
//        Sample Input 1:
//
//        GTTC
//        ACGTTAC
//        Sample Output 1:
//
//        2 1
//        Sample Input 2:
//
//        less
//        queerness
//        Sample Output 2:
//
//        5 1
package algorithms.hamming.distance;

import java.util.*;

public class MinHammingDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String text = sc.nextLine();

        List<String> list = textList(text, pattern.length());
        Map<String, Integer> distance = hammingDistance(list, pattern);
        List<Integer> res = result(distance, text);
        res.forEach(x -> System.out.print(x + " "));

    }
    private static List<String> textList(final String text,
                                         final int patternLength) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= text.length() - patternLength; i++) {
            list.add(text.substring(i, patternLength + i));
        }
        return list;
    }
    private static Map<String, Integer> hammingDistance(final List<String> list,
                                                        final String pattern) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : list) {
            int distance = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != pattern.charAt(i)) {
                    distance++;
                }
            }
            map.put(s, distance);
        }
        return map;
    }
    private static List<Integer> result(final Map<String, Integer> dst,
                                        final String text) {
        List<Integer> result = new ArrayList<>(2);
        Map.Entry<String, Integer> min = null;

        for (Map.Entry<String, Integer> m : dst.entrySet()) {
            if (min == null || min.getValue() > m.getValue()) {
                min = m;
            }
        }
        result.add(text.indexOf(min.getKey()));
        result.add(min.getValue());
        return result;
    }
}

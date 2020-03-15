//Given two strings, a pattern and a text.
// Write a program that prints the first index
// in which the pattern occurs in the text, or -1 if there are no occurrences.
//
//        NB: the empty string is a substring for any string.
//
//        Sample Input 1:
//
//        ACA
//        ACBACAD
//        Sample Output 1:
//
//        3

import java.util.Scanner;

public class SearchSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();

        int index = findPatternIndex(pattern, text);
        System.out.println(index);
    }

    private static int findPatternIndex(final String pattern, final String text) {
        int result = -1;

        if (text.length() < pattern.length()) {
            return result;
        }

        int patternLength = pattern.length();

        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {

            if (text.substring(i, i + patternLength).equals(pattern)) {
                result = i;
                return result;
            }
        }

        return result;
    }
}

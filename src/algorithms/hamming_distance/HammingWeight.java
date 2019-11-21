
//Write a function that takes an unsigned integer and
// return the number of '1' bits it has (also known as the Hamming weight).
//        Input: 00000000000000000000000000001011
//        Output: 3
//        Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

package algorithms.hamming_distance;

public class HammingWeight {
    public int hammingWeight(final int n) {
        String[] binary = Integer.toBinaryString(n).split("");
        int weight = 0;
        for (String s : binary) {
            if (s.equals("1")) {
                weight++;
            }
        }
        return weight;
    }
}

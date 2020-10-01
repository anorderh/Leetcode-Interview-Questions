/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/1/2020                          (might be off for older commits as I'm adding this past committing)
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

import java.util.HashSet;

class SolutionF {

    /**
     * HashSet method where a collection is used to filter unique values and add them * 2 to an int sum. Afterwards,
     * every element in nums subtracts from sum, revealing the int in nums which did not have a pair.
     *
     * @param nums                                      input Array of nums where only 1 value defines 1 element
     * @return
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        HashSet<Integer> uniqueNums = new HashSet();

        for (int currVal : nums) {
            if (!uniqueNums.contains(currVal)) {
                uniqueNums.add(currVal);
                sum += currVal*2;
            }
        }

        for (int currVal : nums) {
            sum -= currVal;
        }
        return sum;

    }

    /**
     * Leetcode method where XOR is used. XOR of a bit and 0 will return that bit. XOR of 2 same bits will return 0.
     * Therefore, by taking XOR of all bits, eventually the only value remaining is bit without a pair. 
     * @param nums
     * @return
     */
    public int singleNumberBest(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
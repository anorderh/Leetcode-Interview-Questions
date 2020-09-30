/**
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each
 * element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */

import java.util.Arrays;

class SolutionH {
    public int[] plusOne(int[] digits) {

        for (int currIndex = digits.length - 1; currIndex >= 0; currIndex--) {
            if (digits[currIndex] != 9) {
                digits[currIndex] += 1;
                break;
            }
            digits[currIndex] = 0;

            if (currIndex - 1 < 0) {
                digits = Arrays.copyOf(digits, digits.length+1);
                digits[0] = 1;
            }
        }

        return digits;

    }
}
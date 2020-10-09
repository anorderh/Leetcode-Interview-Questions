/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/8/2020
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *        LEETCODE PROMPT
 *  --------------------------
 *  Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note:
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * Example 1:
 *
 *      Input: x = 123
 *      Output: 321
 * Example 2:
 *
 *      Input: x = -123
 *      Output: -321
 * Example 3:
 *
 *      Input: x = 120
 *      Output: 21
 * Example 4:
 *
 *      Input: x = 0
 *      Output: 0
 */
class SolutionN {
    public int reverse(int x) {
        long reversedInteger = 0;
        int currDigit;

        do {
            reversedInteger *= 10;
            currDigit = x % 10;
            reversedInteger += currDigit;
            x = x / 10;
        } while (x != 0);

        if (reversedInteger > Integer.MAX_VALUE || reversedInteger < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)reversedInteger;
    }
}
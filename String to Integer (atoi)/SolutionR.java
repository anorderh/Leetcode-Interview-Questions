/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/12/2020
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as
 * possible, and interprets them as a numerical value. The string can contain additional characters after those that form
 * the integral number, which are ignored and have no effect on the behavior of this function. If the first sequence of
 * non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is
 * empty or it contains only whitespace characters, no conversion is performed. If no valid conversion could be performed,
 * a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or
 * INT_MIN (−231) is returned.
 *
 *
 * Example 1:
 *
 *      Input: str = "42"
 *      Output: 42
 * Example 2:
 *
 *      Input: str = "   -42"
 *      Output: -42
 *              Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical
 *              digits as possible, which gets 42.
 * Example 3:
 *
 *      Input: str = "4193 with words"
 *      Output: 4193
 *              Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 *      Input: str = "words and 987"
 *      Output: 0
 *              Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 *      Input: str = "-91283472332"
 *      Output: -2147483648
 *              Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Thefore INT_MIN (−231) is returned.
 *
 * Constraints:
 *      0 <= s.length <= 200
 *      s consists of English letters (lower-case and upper-case), digits, ' ', '+', '-' and '.'.
 */

class SolutionR {
    public int myAtoi(String s) {
        int startIndex, endIndex;
        startIndex = endIndex = 0;

        // identifying index of starting digit, non-whitespace non-digits result in 0 returned
        for (int i = 0; i < s.length(); i++) {
            char selectChar = s.charAt(i);

            if (!Character.isWhitespace(selectChar)) {
                if (Character.isDigit(selectChar) || selectChar == '+' || selectChar == '-') {
                    startIndex = i;
                    endIndex = i+1;
                    break;
                } else {
                    return 0;
                }
            }
        }
        // return 0 if input is empty or is all white space, no pointer allocation
        if ((s.length() == 0) || (startIndex == endIndex)) { return 0; }

        // incrementing endIndex until non-digit or string end is reached
        while (endIndex < s.length() && Character.isDigit(s.charAt(endIndex))) {
            endIndex++;
        }

        // case check for when two numerical signs are adjoined together
        if (endIndex - startIndex == 1 && !Character.isDigit(s.charAt(startIndex))) {
            return 0;
        }

        // try-catch reutrning int, returns associated max/min if Integer overflow occurs
        try {
            return Integer.parseInt(s.substring(startIndex, endIndex));
        } catch (NumberFormatException excpt) {
            if (s.charAt(startIndex) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
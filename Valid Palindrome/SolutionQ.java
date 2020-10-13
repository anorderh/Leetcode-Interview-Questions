/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/12/2020
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 *      Input: "A man, a plan, a canal: Panama"
 *      Output: true
 * Example 2:
 *
 *      Input: "race a car"
 *      Output: false
 *
 * Constraints:
 *      s consists only of printable ASCII characters.
 */

class SolutionQ {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                if (left == s.length()) return true;
            }
            while (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                if (right == -1) return true;
            }

            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
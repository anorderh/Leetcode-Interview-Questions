/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/8/2020
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 *
 *      Input: ["h","e","l","l","o"]
 *      Output: ["o","l","l","e","h"]
 * Example 2:
 *
 *      Input: ["H","a","n","n","a","h"]
 *      Output: ["h","a","n","n","a","H"]
 */

class SolutionM {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            if (s[i] != s[(s.length-1)-i]) {
                char tempChar = s[i];
                s[i] = s[s.length-1-i];
                s[s.length-1-i] = tempChar;
            }
        }
    }
}
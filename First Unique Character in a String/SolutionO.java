/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/12/2020
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 *      s = "leetcode"
 *      return 0.
 *
 *      s = "loveleetcode"
 *      return 2.
 *
 * Note: You may assume the string contains only lowercase English letters.
 */
import java.util.HashMap;

class SolutionO {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> charTable = new HashMap<>(); // lists number of occurences
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char selectChar = s.charAt(i);
            charTable.put(s.charAt(i), charTable.getOrDefault(selectChar, 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            if (charTable.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
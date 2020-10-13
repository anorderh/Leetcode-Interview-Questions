/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/12/2020
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 *      Input: s = "anagram", t = "nagaram"
 *      Output: true
 * Example 2:
 *
 *      Input: s = "rat", t = "car"
 *      Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

import java.util.Arrays;
import java.util.HashMap;

class SolutionP {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charTable = new HashMap<>();
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            charTable.put(s.charAt(i), charTable.getOrDefault(s.charAt(i), 0) + 1);
            charTable.put(t.charAt(i), charTable.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (char selectChar: charTable.keySet()) {
            if (charTable.get(selectChar) != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] Schars = s.toCharArray();
        char[] Tchars = t.toCharArray();
        Arrays.sort(Schars);
        Arrays.sort(Tchars);

        return Arrays.equals(Schars, Tchars);
    }

}
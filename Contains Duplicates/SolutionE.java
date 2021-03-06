/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/1/2020                         (might be off for older commits as I'm adding this past committing)
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 *      Input: [1,2,3,1]
 *      Output: true
 * Example 2:
 *
 *      Input: [1,2,3,4]
 *      Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

import java.util.HashMap;


class SolutionE {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for (int value: nums) {
            if (map.containsKey(value)) {
                return true;
            } else {
                map.put(value, true);
            }
        }

        return false;
    }
}
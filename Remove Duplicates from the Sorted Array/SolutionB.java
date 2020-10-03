/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/1/2020                          (might be off for older commits as I'm adding this past committing)
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 *    Given nums = [1,1,2],
 *    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *    It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 *    Given nums = [0,0,1,1,1,2,2,3,3,4],
 *    Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *    It doesn't matter what values are set beyond the returned length.
 *
 * Clarification:
 *
 *    Confused why the returned value is an integer but your answer is an array?
 *    Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *    Internally you can think of this:
 */

public class SolutionB {

    // optimization revolved around pointer integer "length" also serving as new subArray's length

    public int removeDuplicates(int[] nums) {
        int length = 1;
        // since every array has atleast 1 element, there is atleast 1 unique value in every array, starting length at 0

        // EXAMPLE: [0,0, 1, 1, 1,1,1,1,2,2,3,3,4],
            // Since prompt establishes operating arrays are already sorted, all duplicates will be side-by-side. Therefore,
            // relative operators on elements next to each other are applicable in deciding if dupes are present or not
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[length] = nums[i+1];
                length++;
            }
        }

        return length;

    }
}

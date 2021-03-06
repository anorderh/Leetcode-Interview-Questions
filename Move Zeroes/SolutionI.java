/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/1/2020                        (might be off for older commits as I'm adding this past committing)
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Given an array nums, write a function to move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * Example:
 *
 *      Input: [0,1,0,3,12]
 *      Output: [1,3,12,0,0]
 *
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

class SolutionI {
    public void moveZeroes(int[] nums) {
        int nonZeroPointer = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroPointer++;
                nums[nonZeroPointer] = nums[i];
            }
        }

        for (int i = nonZeroPointer+1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
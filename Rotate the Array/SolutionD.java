/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/1/2020                         (might be off for older commits as I'm adding this past committing)
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Follow up:
 *
 *     Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *     Could you do it in-place with O(1) extra space?
 */
public class SolutionD {

    /**
     * rotate() copies nums into a new array and identifies the applicable number of rotations. if an array rotates by
     * a value equivalent to its length, the values all end up in the same position. therefore, by using modulo, we can
     * identify the necessary rotations to execute without always adhering to the input "k" value.
     *
     * additionally, rotation by k translates to taking the last k elements of the array, and adding them to the front,
     * therefore System.arraycopy is used to perform this.
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        // arraycopy format: (srcArray, srcPosition, destArray, destPosition, #elements to copy)

        int rotations = k % nums.length;

        System.arraycopy(copy, copy.length - rotations, nums, 0, rotations);
        System.arraycopy(copy, 0, nums, rotations, copy.length - rotations);
    }
}

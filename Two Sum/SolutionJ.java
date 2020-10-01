import java.util.HashMap;
import java.util.Map;


class SolutionJ{

    /**
     * first attempt at the problem, worrying since instead of iteration dependent on input size, I made it dependent
     * on ELEMENT size (constantly incrementing and decrementing from target's half to identify "complement"'s presence)
     *
     * @param nums                                                  input array of ints with only 1 pair adding to target
     * @param target                                                sum desired to add up to
     * @return                                                      int[] containing indices within nums
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // initializing nums values in HashTable with indices
        // stored within HashMap an int array as "value" to track any duplicate values
        HashMap<Integer, int[]> indexTable = new HashMap<Integer, int[]>();
        for (int i = 0; i < nums.length; i++) {
            if (indexTable.containsKey(nums[i])) {
                indexTable.put(nums[i], new int[]{indexTable.get(nums[i])[0], i});
            } else {
                indexTable.put(nums[i], new int[]{i, -1});
            }
        }

        // lower and upper vals to look for numbers adding to target
        int lowerVal, upperVal;
        if (target % 2 == 0) {
            lowerVal = upperVal = target / 2;
        } else {
            lowerVal = target / 2;
            if (target < 0) {
                upperVal = target / 2 -1;
            } else {
                upperVal = target / 2 + 1;
            }
        }

        // checking if upper & lower values present, if not incrementing & decrementing
        // also checks if lowerVal has 2 indices and if lowerVal == upperVal
                // if 1 index and are equal, continue iterating
                // if 1 index and not equal, safe to leave
                // if 2 indices and not equal, safe to leave
                // if 2 indices and are equal, safe to leave
        while (!(indexTable.containsKey(lowerVal) && indexTable.containsKey(upperVal))
                || ((indexTable.get(lowerVal)[1] == -1) && upperVal == lowerVal)) {
            lowerVal--;
            upperVal++;
        }

        // if both values are same, pulls 2nd index from index 1 in shared array
        result[0] = indexTable.get(lowerVal)[0];
        if (lowerVal == upperVal) {
            result[1] = indexTable.get(lowerVal)[1];
        } else {
            result[1] = indexTable.get(upperVal)[0];
        }


        return result;
    }

    /**
     * Leetcode's offered solution, also operates off of "complement's" use but instead of identifying and then incrementing/
     * decrementing, it TEMPORARILY stores complement of each element identified in nums and checks if map contains it.
     *
     * If not, adds nums element to Hash and continues iterating for complements. Eventually element is found with pre-existing
     * complement for Target value and an array is returned containing complement's index (stored as 'value' in Hash) and
     * original element's index (stored as 'i' in for loop)
     *
     *
     * @param nums                                                  input array of ints with only 1 pair adding to target
     * @param target                                                sum desired to add up to
     * @return                                                      int[] containing indices within nums
     */
    public int[] twoSumLeetcode(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * main method for testing with initialized array and target value
     */
    public static void main(String[] args) {
        int[] example = {3, 2, 4};
        int target = 6;
        int[] answer = new int[2];

        // answer = twoSum(example, target);
        // answer = twoSumLeetcode(example, target);
    }
}
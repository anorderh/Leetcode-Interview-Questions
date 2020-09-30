/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 *      Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *      Output: [2,2]
 * Example 2:
 *
 *      Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *      Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */

import java.util.HashSet;
import java.util.ArrayList;

class SolutionG {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> ignoreIndices = new HashSet<Integer>();
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        int[] primArray;

        for (int i = 0; i < nums1.length; i++) {

            if (intersect.size() >= nums2.length) {
                break;
            }
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !ignoreIndices.contains(j)) {
                    intersect.add(nums1[i]);
                    ignoreIndices.add(j);
                    break;
                }
            }
        }

        primArray = new int[intersect.size()];

        for (int i = 0; i < intersect.size(); i++) {
            primArray[i] = intersect.get(i);
        }

        return primArray;
    }

}
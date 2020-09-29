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
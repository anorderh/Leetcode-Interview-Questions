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
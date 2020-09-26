import java.util.HashMap;

class SolutionF {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int value: nums) {
            if (map.containsKey(value)) {
                map.replace(value, (map.get(value) - 1));
            } else {
                map.put(value, 1);
            }
        }

        for (int value: nums) {
            if (map.get(value) == 1) {
                return value;
            }
        }

        return -1;
    }
}
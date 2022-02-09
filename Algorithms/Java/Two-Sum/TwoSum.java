import java.util.ArrayList;
class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int minusTarget;
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            minusTarget = target - nums[i];
            if(map.containsKey(minusTarget)) {
                result[0] = map.get(minusTarget);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

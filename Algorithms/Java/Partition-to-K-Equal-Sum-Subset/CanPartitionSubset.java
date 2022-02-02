class CanPartitionSubset {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        boolean[] v = new boolean[nums.length];
        return sol(0, nums, v, sum / k, sum / k, k);
    }

    private boolean sol(int start, int[] nums, boolean[] v, int sum, int left, int next) {
        if (next == 1) {
            return true;
        }

        if (left == 0) {
            return sol(0, nums, v, sum, sum, next - 1);
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > left) {
                return false;
            }

            if (v[i] == true) {
                continue;
            }

            v[i] = true;

            if (sol(i + 1, nums, v, sum, left - nums[i], next)) {
                return true;
            }

            v[i] = false;
        }
        return false;
    }
}

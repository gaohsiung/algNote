package Alg.S1;

class L81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,1,1,1};
        int target = 3;
        System.out.println("--------------------------------------");
        L81 sol = new L81();
        boolean ret = sol.search(nums, target);
        System.out.println(ret);
    }
}

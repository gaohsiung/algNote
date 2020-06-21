package Alg.S1;

class L153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] > nums[right]) {
            return nums[right];
        } else {
            return nums[left];
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6};
        System.out.println("--------------------------------------");
        L153 sol = new L153();
        int ret = sol.findMin(nums);
        System.out.println(ret);
    }
}

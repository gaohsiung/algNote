package Alg.S1;

class L154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            mid = left + (right - left) / 2;

            if (nums[mid] == nums[left]) {
                left ++;
            } else if (nums[mid] > nums[left]){
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
        int[] nums = new int[] {2,1,2,2,2};
        System.out.println("--------------------------------------");
        L154 sol = new L154();
        int ret = sol.findMin(nums);
        System.out.println(ret);
    }
}

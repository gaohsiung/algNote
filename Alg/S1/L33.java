package Alg.S1;

class L33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {// equals !!!
                if (nums[mid] > target && nums[left] <= target) { // equals !!!
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) { // equals !!!
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {3,4,5,1};
        int target = 1;
        System.out.println("------------------------------------------------");
        L33 l33 = new L33();
        int ret = l33.search(nums, target);
        System.out.println(ret);
    }
}

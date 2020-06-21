package Alg.S1;

class L275 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = citations.length - 1;
        int mid;
        if (citations[right] == 0) {
            return 0;
        }
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (citations[left] >= citations.length - left) {
            return citations.length - left;
        } else {
            return citations.length - right;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] {11,15};
        System.out.println("--------------------------------------");
        L275 sol = new L275();
        int ret = sol.hIndex(nums);
        System.out.println(ret);
    }
}

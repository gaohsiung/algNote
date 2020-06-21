
public class T183 {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        
        long sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i];
        }
        if (sum / k < 1) {
            return 0;
        }
        long left = 1;
        long right = sum / k;
        long mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (valid(L, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }

    private boolean valid(int[] arr, int k, long curL) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i] / curL;
        }
        if (count >= k) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        T183 sol = new T183();
        int[] arr = new int[] {232, 124, 456};
        int k = 7;
        System.out.println(sol.woodCut(arr, k));
    }

    
}
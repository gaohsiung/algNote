public class T92 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int[] nums = A;
        boolean[][] dp = new boolean[nums.length+1][m+1];
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j-nums[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] || (dp[i-1][j-nums[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int j = dp[0].length - 1; j >= 0; j--) {
            if (dp[dp.length-1][j]) {
                return j;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        T92 sol = new T92();
        System.out.println(sol.backPack(10, new int[]{3,4,8,5}));
    }
}
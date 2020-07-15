public class T125 {
    public int backPackII(int bagSize, int[] itemSizes, int[] itemValues) {
        int[][] dp = new int[itemSizes.length+1][bagSize+1];
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - itemSizes[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], itemValues[i-1]+dp[i-1][j-itemSizes[i-1]]);
                }
            }
        }
        int max = 0;
        for (int j = 0; j < dp[0].length; j++) {
            max = Math.max(dp[dp.length - 1][j], max);
        }
        return max;
    }
}
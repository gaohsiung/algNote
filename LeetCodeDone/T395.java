public class T395 {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values.length <= 2) {
            return true;
        }
        int len = values.length;
        int[] dp = new int[len];
        dp[len - 1] = values[len - 1];
        int sum = values[len - 1];
        for (int i = len - 2; i >= 0; i --) {
            sum += values[i];
            int dpi2 = i+2 >= len ? 0:dp[i+2];
            int dpi3 = i+3 >= len ? 0:dp[i+3];
            int dpi4 = i+4 >= len ? 0:dp[i+4];
            dp[i] = Math.max(values[i] + Math.min(dpi2, dpi3), 
            values[i] + values[i+1]+Math.min(dpi3, dpi4));
        }
        return dp[0] > sum - dp[0];
    }
}
// sum version
// public boolean firstWillWin(int[] values) {
//     if (values.length <= 2) {
//         return true;
//     }
//     int[] sum = new int[values.length];
//     sum[values.length - 1] = values[values.length - 1];
//     sum[values.length - 2] = sum[values.length - 1] + values[values.length - 2];
//     int[] dp = new int[values.length];
//     dp[values.length - 1] = values[values.length - 1];
//     dp[values.length - 2] = values[values.length - 1] + values[values.length - 2];

//     for (int i = values.length - 3; i >= 0; i--) {
//         sum[i] = sum[i+1] + values[i];
//         dp[i] = Math.max(values[i] + (sum[i+1] - dp[i+1]), 
//                         values[i] + values[i+1] + (sum[i+2] - dp[i+2]));
//     }
//     return dp[0] > sum[0] - dp[0];

// }
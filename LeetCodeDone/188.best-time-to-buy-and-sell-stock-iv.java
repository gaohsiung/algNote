import java.util.*;

/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        if (k >= prices.length/2) {
            int sum = 0;
            for(int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    sum += prices[i] - prices[i-1];
                }
            }
            return sum;
        }
        int[] buys = new int[k+1];
        int[] sells = new int[k+1];
        Arrays.fill(buys, Integer.MIN_VALUE);
        int[] preBuy = buys;
        int[] preSell = sells;
        for (int i = 0; i < prices.length; i++) {
            for (int kk = 1; kk <= k; kk++) {
                sells[kk]= Math.max(preSell[kk], preBuy[kk] + prices[i]);
                buys[kk] = Math.max(preBuy[kk], preSell[kk-1] - prices[i]);
                preBuy = buys;
                preSell = sells;
            }
        }
        return sells[k];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(2, new int[]{3,3,5,0,0,3,1,4}));
    }
}
// @lc code=end

/*
if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        int[] buys = new int[k];
        int[] sells = new int[k];
        for (int kk = 1; kk < k; kk++) {
            int preBuy = -prices[0];
            int preSell = 0;
            for (int i = 0; i < prices.length; i++) {
                if (i == 0) {
                    buys[kk] = preBuy;
                    sells[kk] = preSell;
                    preBuy = buys[kk];
                    preSell = sells[kk];
                    continue;
                }
                buys[kk] = Math.max(preBuy, preSell - prices[i]);
                sells[kk]= Math.max(preSell, preBuy + prices[i]);
                preBuy = buys[kk];
                preSell = sells[kk];

            }
        }
        return sells[k-1];
*/
// reference code
/*
if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int sell[][] = new int[k+1][len];
        int buy[][] = new int[k+1][len];
        for (int i = 1; i <= k; i++) {
            buy[i][0] = -prices[0];
            for(int j = 1; j < len; j++) {
                sell[i][j] = Math.max(sell[i][j-1], buy[i][j-1] + prices[j]);
                buy[i][j] = Math.max(buy[i][j-1], sell[i-1][j-1] - prices[j]);
            }
        }
        return sell[k][len - 1];
*/
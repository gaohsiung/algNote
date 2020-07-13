/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy;
        int sell = 0;
        int prevBuy = Integer.MIN_VALUE;
        int prevSell = 0;
        int twoDayAgoSell = 0;
        for (int p: prices) {
            buy = Math.max(prevBuy, twoDayAgoSell - p);
            sell = Math.max(prevSell, prevBuy + p);
            twoDayAgoSell = prevSell;
            prevBuy = buy;
            prevSell = sell;
        }
        return sell;
    }
}
// @lc code=end


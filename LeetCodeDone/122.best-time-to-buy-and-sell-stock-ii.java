/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int prevBuy = Integer.MIN_VALUE;
        int prevSell = 0;
        int buy;
        int sell = 0;
        for (int p: prices) {
            buy = Math.max(prevBuy, prevSell - p);
            sell = Math.max(prevSell, prevBuy + p);
            prevBuy = buy;
            prevSell = sell;
        }
        return sell;
    }
}
// @lc code=end


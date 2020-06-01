## Greedy
1. dp -~~~~> greedy
2. dp实现优化，greedy是算法，时间复杂度上的优化
3. greedy：local最优 -> 全局最优
   - 分叉时，每次直接选到了正确的路径，不用一个一个尝试
4. backpack问题
   - 可分割：按单位体积价值排序，每一步都有最优选择，不用尝试
   - 不可分割：
     - dp[i][v] [0, i] items 能凑成体积V的max value(weight 代指value价值)
     - dp[i][v] = max(dp[i-1][v], items[i].weight + dp[i-1][v-items[i].volume])
## L300
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - dp
   - dp[i]以i为结尾的最长increase subsequence
   - dp[i] = max(dp[j] + 1) with 0 <= j < i and nums[j] < nums[i]
   - 时间复杂度：O(n^2)
### S2
1. Ideas：
   - greedy
   - 定向搜索（logn)，而不是全局搜索（n）
## Dijstra Algorithm
1. Notes
   - 最短路径
   - 权值为正
2. Follow up
   - null
## 种花
1. Notes
   - 种花，1d，不能超过连续3朵花
2. Follow up
   - null
### S1
1. Ideas：
   - 能种就种
## L44
1. Notes
   - 
2. Follow up
   - null
### S1
1. Ideas：
   - greedy
   - http://techbow.com/app/lesson/5e860e934881173f399b36d9
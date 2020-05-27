## DP
1. DP不是算法，是dfs+pruning的一种优化方式。constant factor优化
2. 顺序填值+非离散，pruning -> dp
   - pruning：搜索状态 -- dp：几维dp
   - pruning：返回值 -- dp：dp类型
   - pruning：mem -- dp：dp含义
   - pruning：base case -- dp：初始化
   - pruning：recursion body -- dp：状态转移方程
3. dp能优化constant factor的pruning，是基于worst case，如果返回值是boolean，或者是一通百通，average情况下，一些dfs+pruning可能很快得到想要的值，快速返回，而dp的从0开始一个一个填值。
## L72
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L132
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - dp
   - dp[i]: str [0, i)的最小切成pal的个数
   - dp[0] = 0，空str
   - dp[i] = 1 + Math.min(dp[j - 1 + 1]) when str[j, i)是pal
   - 两个for loop i j，中间如果每次判断pal也要花费m
     - 可以preprocessin创建一个isPal的2d boolean array，isPal[i][j]: s[i] == s[j] && isPal[i+1][j-1]
```java
for (i = len - 1; i > 0; i++) {
    for (j = i; j < len; j++) {
        if (i == j) isPal[i][j] = true;
        else if (i+1 == j) {
            isPal[i][j] = s[i] == s[j];
        } else {
            isPal[i][j] = (s[i] == s[j] && isPal[i+1][j-1]);
        }
    }
}
```
   - 时间复杂度: O(n^2)
   - 可以把preprocessing这个isPal和主体dp填表整合在一起
     - 即dp[i]: [i, len)的最小切数
```java
for (i = len - 1; i >= 0; i--) {
    for (j = 1; j< len; j++) {
        if (i == j) isPal[i][j] = true;
        else if (i+1 == j) {
            isPal[i][j] = s[i] == s[j];
        } else {
            isPal[i][j] = (s[i] == s[j] && isPal[i+1][j-1]);
        }

        if(isPal[i][j]){
            dp[i] = min(dp[i], 1+dp[j]);
        }
    }
}
return dp[0];
```
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L312
1. Notes
   - null
2. Follow up
   - 时间复杂度：n^3
### S1
1. Ideas：
   - dp[i][j]: [i, j] 从i到j的最大cost
   - dp[i][j]: i <= k <= j, ```max(dp[i][k] + dp[k][j] + nums[i-1]*nums[j+1]*num[k])```
   - dp[x][x] = nums[x]
```java
for(int i = len - 1; i >= 0; i--) {
    for (int j = i; j < len; j++) {
        for (int k = i; k <= j; k++) {
            val = 0;
            val += (i == k)? 0: dp[i][k-1];
            val += (j == k)? 0: dp[k+1][j];
            val += ((i == 0)? 1: nums[i-1])*nums[k]*((j== len-1)?1:nums[j+1]);
            dp[i][j] = Math.max(val, dp[i][j]);
        }
    }
}
return dp[0][len-1];
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L
1. Notes
   - 一排球，每个球有val，两个玩家轮流从左边拿1个或者2个，是否能guarantee 先手玩家获胜
2. Follow up
   - 可以从左或者从右拿1个
   - dp[i][j] = max(nums[i] + min(dp[i+2][j], dp[i+1][j-1]), nums[j]+min(dp[i+1][j-1],dp[i][j-2]))
```java

```
### S1
1. Ideas：
   - dp[i]: 剩余的[i, len)中，a能拿的最大val
   - 这里dp不能定义boolean，因为boolean没有val的传递，很难使用dp做
   - 玩家每次都是最大收益，所以先手选最大，后手由于对手选最大，所以这里后手默认选最小，这样才能guarantee win
   - dp[i] = max(nums[i] + min(dp[i+2], dp[i+3]), nums[i]+num[i+1]+min(dp[i+3],dp[i+4]))
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```

## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
}
```



## BST
1. 查找：BST vs Hashmap vs Trie
   - range search -> BST
   - min max get: hashmap中getMin/Max和remove的tradeoff
   - BST是由TreeSet实现
2. sort
   - merge vs quick
     - stable vs unstable?
       - e.g. Student sort by name then score vs. Student sort by score then name
       - 对primitive排序stable没意义
       - 对object，stable有意义
3. TreeMap -> 基于bst的map
   - get range，lowerkey（小于key的最大值），floorKey（小于等于key的最大值），higherkey（大于key的最小值），ceilKey（大于等于key的最小值）时间复杂度logn
   - TreeMap是基于key排序
4. TreeSet -> 基于bst的set
   - lower/floor/higher/ceiling  时间复杂度logn
5. consistent hashing处理server expand
   - consistent circle 使用TreeSet实现
6. 使用stack iterate BST （inorder）
   - left++
   - right++
   - BST版的2sum
```java
public boolean bst2Sum(TreeNode root, int target) {
    \\cc
    Stack<TreeNode> ls = initializeLeft(root);
    Stack<TreeNode> rs = initializeRight(root);

    while (!ls.isEmpty() && !rs.isEmpty()) {
        TreeNode l = ls.peek();
        TreeNode r = rs.peek();
        if (l == r) {
            return false;
        }
        if ()
    }
}
```
## L220
1. Notes
   - null
2. Follow up
   - 存在duplicates，同时index差值至少大于等于 k？
### S1
1. Ideas：
   - 使用TreeSet找range，nums[i] - t <= nums[j] <= nums[i] + t
   - 时间复杂度：O(nlogn)
2. Code
```java
public boolean contains(int[] nums, int k, int t) {
    //cc

    TreeSet<Integer> window = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
        if (i > k) {
            window.remove(nums[i - k]);
        }
        Integer val = window.floor(nums[i] + t);
        if (val != null && val >= (nums[i] - t)) {
            return true;
        }
        window.add(nums[i]);
    }
    return false;
}
```
## L270
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
public int closestVal(TreeNode root, double target) {
    //cc

    TreeNode cur = root;
    int ret = root.val;
    while (cur != null) {
        if (abs(ret - target) > Math.abs(cur.val - target)) {
            ret = cur.val;
        }
        if (cur.val < target) {
            cur = cur.right;
        } else {
            cur = cur.left;
        }
    }
    return ret;
}
```
## L272
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - nul
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
## L
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null




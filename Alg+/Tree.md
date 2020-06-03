## Tree
1. 无环，不需要查重，没有pruning，没有dp
2. BST，想象成1d array，在array上做好，再想象tree上的类似操作
3. 如果tree的brutal force solution是O(n)，则可以考虑每次分叉只走一边（参考L222）
## L95
1. Notes
   - null
2. Follow up
   - 求总数
     - 可以使用dp
### S1
1. Ideas：
   - null
2. Code
```java
private List<TreeNode> dfs(int start, int end) {
    if (start > end) {
        return Arrays.asList(null);
    }
    for (int i = start; i < = end; i++){
        List<TreeNode> lefts = dfs(start, i - 1);
        List<TreeNode> rights  = dfs(i+1, end);
        for (TreeNode l: lefts) {
            for (TreeNode r: rights) {
                TreeNode root = new TreeNode(i);
                root.left = l;
                root.right = r;
                res.add(root);
            }
        }
    }
    return res;
}
```
## MyTree （All treenode either 0 or 2 children)
1. Notes
   - Given number of leaves n, 有多少种MyTree
2. Follow up
   - L894
     - given number of nodes
### S1
1. Ideas：
   - null
2. Code
```java
private List<TreeNode> dfs(int n) {
    if (n == 0) {
        return Arrays.asList(null);
    }
    if (n == 1) {
        return Arrays.asList(new TreeNode());
    }
    List<TreeNode> res= new ArrayList<>();
    for (int i = 1; i < n; i++) {
        List<TreeNode> left = dfs(i);
        List<TreeNode> right = dfs(n-i);
        for (TreeNode l: left) {
            for (TreeNode r: right) {
                TreeNode root = new TreeNode();
                root.left = l;
                root.right = r;
                res.add(root);
            }
        }

    }
    return res;
}
```
## L99
1. Notes
   - global variable -> thread unsafe
   - 只要交换一次两个错的，即定位到两个错误的TreeNode
2. Follow up
   - L98
### S1
1. Ideas：
   - inorder 遍历，想象成一个1d sort array，然后转化成tree上的操作
   - inorder遍历，第一次违反prev > cur时，prev是要换的；第二次违反prev > cur时，cur是要换的
2. Code
```java
private TreeNode prev = null;
private void dfs(TreeNode cur, TreeNode[] mistakes) {
    if (cur == null) {
        return;
    }
    dfs(cur.left, mistakes);
    if (prev != null && prev.val > cur.val) {
        mistake[1] = cur; // 第一次要prev，这里无脑赋值cur，因为肯定有第二次，直接覆盖之前的错的cur
        if (mistake[0] == null) {
            misktake[0] = prev;
        }
    }
    prev = cur;
    dfs(cur.right, mistakes);
    return;
}
```
## L109
1. Notes
   - 这题是list，array直接O(1)找中间
2. Follow up
   - L117
### S1
1. Ideas：
   - 每次找中点是O(n)，劈成两半，找两个n/2的中点，以此类推，类似merge sort，O(n)劈成两个O(n/2)的问题，时间复杂度O(nlogn)
### S2
1. Ideas：
   - O(n)
   - dfs(start, end)
## L222
1. Notes
   - 
2. Follow up
   - null
### S1
1. Ideas：
   - worst case: general Binary tree O(n)，每叉都走
   - best case: full tree O(logn)，只走一叉
   - complete tree: 中间
     - 左右子树有一个是full tree
     - 根的left和right，分别左边走到底，比较两个左边的长度：
       - hL = rL + 1: 右边肯定是full tree
       - hL == rL: 左边肯定是full tree
     - 时间复杂度：O(logn*logn)
2. COde
```java
private int dfs(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int hl = getHeight(root.left);
    int hr = getHeight(root.right);
    if (hl == hr+1) {
        return dfs(root.left) + 1 + 1 << hr -1; //不要写Math.pow去算2的指数
    } else if (hl == hr) {
        return 1 << hr - 1 + 1 + dfs(root.right);
    } else {
        throw new IllegalArgumentException("Input is not a complete binary tree");
    }
}
private int getHeight(TreeNode root){
    int cnt = 0;
    TreeNode cur = root;
    while(cur != null) {
        cur = cur.left;
        cnt++;
    }
    return cnt;
}
```
## L241
1. Notes
   - 不要求去重
   - 符号固定
2. Follow up
   - 数学表达式转为syntax tree
     - 使用两个stack，一个符号stack（TreeNode），一个数字stack（TreeNode）
   - 找所有值得最大值
     - dp，dp[start][end] = {max, min}
### S1
1. Ideas：
   - construct 不同的syntax tree，计算由下到上
2. Code
```java
private List<Integer> dfs(String input, int start, int end) {

    List<Integer> res = new ArrayList<>();
    boolean isNum = true;
    for (int i = start; i <= end; i++) {
        char ch = input.charAt(i);
        if (ch == '+' || ch == '-' || ch == '*') {
            isNum = false;
            List<Integer> lefts = dfs(input, start, i-1);
            List<Integer> rights = dfs(input, i+1, end);
            for (Integer l: lefts) {
                for (Integer r: rights) {
                    res.add(calculate(ch, l, r));
                }
            }
        }
    }
    if (isNum) {
        res.add(Integer.valueOf(intput.subString(start, end+1)));
    }
    return res;
}
```
## L250
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - null
2. Code
```java
private boolean dfs(TreeNode root, int target, int[] count) {
    if (root == null) {
        return true;
    }
    if (!dfs(root.left, root.val) || !dfs(root.right, root.val)) {
        return false;
    }
    count[0]++;
    return root.val == target;
}
```
## L298
1. Notes
   - null
2. Follow up
   - 可以左子树到右子树形成最长序列
     - 左 -1 or +1
     - 右 -1 or +1
     - 返回两个值
   - 返回具体最长路径
     - 使用hashmap记录每个pair，同时记录最长连续序列的出发点
### S1
1. Ideas：
   - dfs，一次遍历找到最长连续
2. Code
```java
int globalMax = Integer.MIN_VALUE;
private int dfs(TreeNode) { // 以root为根的最长连续
    if (root == null) {
        return 0;
    }
    ret = 1;
    if (root.left != null && root.val + 1 == root.left.val) {
        ret = left + 1;
    }
    if (root.right != null && root.val + 1== root.right.val) {
        ret = Math.max(ret, right + 1);
    }
    globalMax = Math.max(globalMax, ret);
    return ret;
}
```
## L333
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - 使用一个3 size的array记录左子树或者右子树的最小最大，和如果是bst的size，作为返回值
   - 这里是3 size，最好wrap 成class，大于2个不管是相同type还是不同type，都wrap成class
   - 注意base case，如果是null，直接return null
   - 当前TreeNode返回最小最大值时，注意判断左右子树是否有null的情况，是null返回root.val，不是再比较





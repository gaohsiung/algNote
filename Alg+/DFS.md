## DFS
1. Topics:
   - all possible solutions
   - 不是最短路径，也不是层级搜索
   - dfs + pruning = dp
2. 套路
   - 是否加visited？
   - 是否需要helper？
```java
ReturnType dfs(cur, <visited?>) {
    //base case: search success
    //base case: search fail
    // 有时候success和fail的情况可以并到for loop里call 完dfs之后就直接处理，这时候有prev的信息，相对比较好处理
    set visited to true?
    for (each_branch) {
        // update value/state
        dfs(next);
        // set back value/state (in pair!!!)
    }
    set visited back to false if set true
}
```
## L79
1. Notes
   - clarify：
     - 方向？
     - 可不可以复用？
2. Follow up
   - null
### S1
1. Ideas：
   - dfs
   - 时间复杂度：m * n * 2^k
   - bfs很难做，因为不是最短路径问题
2. Code
```java
class Solution {
    public boolean exist(char[][] board, String word) {
        // cc
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        // visited all false
        return false;
    }
    private boolean dfs(char[][] matrix, int i, int j, String word, int idx, boolean[][] visited) {
        int len = word.length();
        int row = matrix.length;
        int col = matrix[0].length;
        if (idx == len) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= col || word.charAt(idx) != matrix[i][j] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        idx++;
        boolean ret = false;
        for (int[] dir: DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            boolean ret = dfs(matrix, ii, jj, word, idx, visited));
            if (ret)
                break;
            }
        }
        visited[i][j] = false;
        return ret;
    }
}
```
## L22
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - tree搜索问题
   - 没有环，不需要visited check
   - delta = #("(") - #(")")
     - at the end: delta = 0
     - in the middle delta >= 0
     - in the middle delta < 0 -> not valid
     - delta可以使用stack，但是当括号种类不止一个时，不能使用一个stack
   - 时间复杂度：tree搜索，O(2^n)
2. Code
```java
class Solution {
    public List<String> generateParenthesis(int n) {
        // cc

        List<String> res = new LinkedList();
        dfs(res, new StringBuilder(), n, 0); // inline
        return res;
    }
    private void dfs(List<String> res, StringBuilder path, int n, int delta) {
        int len = path.length();
        if (int len == 2*n && delta == 0) {
            res.add(path.toString());
            return;
        }
        if (len == 2*n || delta < 0) {
            return;
        }

        path.append('(');
        dfs(res, path, n, delta+1);
        path.setLength(len);

        path.append(')');
        dfs(res, path, n, delta-1);
        path.setLength(len);


    }
}
```
## L301
1. Notes
   - null
2. Follow up
   - 求任意一个最少删除的解
     - 使用stack
     - 不使用stack，两pass
### S1
1. Ideas：
   - 搜索问题
   - 最少删几次，先得到最少删左括号的个数，和最少删右括号的个数（左右有可能都要删除，e.g. ")("）
   - tree搜索，看到左括号：删？不删？同理看到右括号：删？不删？比较和要删的个数作为success和fail case。
   - 使用delta来track
   - 去重？e.g. ()())()，删除第二个右括号和删除第三个右括号得到重复的相同的结果 -> ()()()。
     - 使用hashset 存result
     - subset去重思路 -> adjacent + 重复只取第一个
       - 这里删除就是只删第一个重复
   - 时间复杂度：worst case：））））（（（（
     - O(n + 2^n)
   - 空间复杂度：res+栈空间
2. Code
```java
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // cc

        int[] rm = calMRP(s);
        List<String> res = new LinkedList<>();
        dfs(res, new StringBuilder(), s, 0, rm[0], rm[1], 0);
        return res;
    }

    private int[] calMRP(String s) {
        int rmL = 0;
        int rmR = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                rmL ++;
            } else if (ch == ')') {
                if (rmL > 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        return new int[]{rmL, rmR};
    }

    private void dfs(List<String> res, StringBuilder path, String s, int idx, int rmL, int rmR, int delta) {
        int len = s.length();
        if (rmL == 0 && rmR == 0 && delta == 0 && idx == len) {
            res.add(path.toString());
            return;
        }
        if (idx == len || rmL < 0 || rmR < 0 || delta < 0) {
            return;
        }

        char ch = s.charAt(idx);
        idx++;
        if (ch == '(') {
            // remove
            dfs(res, path, s, idx, rmL - 1, rmR, delta);
            // keep
            // 去重 跳重复！
            path.append('(');
            dfs(res, path, s, idx, rmL, rmR, delta+1);
            path.setLength(path.length() - 1);
        } else if (ch == ')') {
            // remove
            dfs(res, path, s, idx, rmL, rmR-1, delta);
            // keep
            path.append(')');
            dfs(res, path, s, idx, rmL, rmR, delta-1);
            path.setLength(path.length() - 1);
        } else {
            path.append(ch);
            dfs(res, path, s, idx, rmL, rmR, delta);
            path.setLength(path.length() - 1);
        }
    }
}
```
## L93
1. Notes
2. Follow up
   - L282
     - 拼数分叉
     - calculator相关的题
       - 只有+ -，one pass
       - 有 + - *，one pass，存last value，a + b*c = (a+ b - b) + b * c (last value is b); a + b * c * d = (a + bc - bc) + bc * d (last value = b*c)
       - 有 + - （ ）：使用stack
       - 有 + - * （ ）：使用stack以及last value
     - 时间复杂度：三叉（+-*）树，O(3^n)
     - 空间复杂度：O(n) （path+栈空间）
```java
public List<string> eval(String s, int target) {
    //cc

    List<String> res = new LinkedList<>();
    dfs(res, new StringBuilder,s, 0, 0, 0, target);
    return res;
}
private void dfs(List<String> res, StringBuilder path, String s, int idx, int sum, int lastVal, int target) {
    int len = s.length();
    if (idx == len){
        if (sum == target) {
            res.add(path.toString());
            return;
        }

        for (int i = idx; i < len; i++) {
            int pathLen = path.length();
            if (pathLen != 0) {
                val = val * 10 + (s.charAt(i) - '0');
                path.append('+'+val);
                dfs(res, path, s, i+1, sum + val, val, target);
                path.setLength(pathLen);
                path.append('-'+val);
                dfs(res, path, s, i+1, sum - val, -val, target); // 注意这里lastVal
                path.setLength(pathLen);
                path.append('*'+val);
                dfs(res, path, s, i+1, (sum - lastVal) + lastVal * val, lastVal * val, target);
                path.setLength(pathLen);
            } else {
                path.append(val);
                dfs(res, path, s, i+1, sum + val, val, target);
                path.setLength(pathLen);
            }
        }
    }
}
```
   - word break的dfs做法
### S1
1. Ideas：
   - 拼数分叉
   - 最大拼3个数字
   - 时间复杂度：O(k)，如果不是分4段，可以随便分，则是每次recursion中for loop 3，三叉树，3^n
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }

    private void dfs(List<String> res, StringBuilder path, String s, int idx, int part) {
        int len = s.length();
        if (idx == len && part == 4) {
            path.setLength(path.length() - 1); // remove last dot "."
            res.add(path.toString());
            return;
        }
        if (idx == len && part > 4) {
            return;
        }


        for (int l = 1; i <= 3; l++) {
            if (idx+l > len) {
                break;
            }
            str = s.subString(idx, idx+l);
            int val = Integer.valueOf(str);
            if (val >= 0 && val <= 255) {
                int pathLen = path.length();
                path.append(val + ".");
                dfs(res, path, s, idx + l, part + 1);
                path.setLength(pathLen);
            }
            if (val == 0) break; // 跳过所有0开头的组合，例如 0255255，上面if进入了 0.255255，上面出来了之后，后面的02和025都不是valid，这里要clarify一下，直接break出去了
        }
    }
}
```
## L320
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - 先找出res的个数，一共2^n，因为每个位置有字母和数字两种情况：
     - e.g. abc有 abc, ab1, a1c, a11(a2); 1bc,1b1, 11c(2c), 111(3)
     - 类似L22，每次选择字母还是数字
     - 注意合并，a11 -> a2
   - 时间复杂度：O(2^n)
2. Code
```java
class Solution {
    public List<String> solution(String word) {
        // cc

        List<String> res = new LinkedList<>();
        dfs(res, new StringBuilder(), word, 0, 0);
        return res;
    }
    private void dfs(List<String> res, StringBuilder path, String s, int idx, int cnt) {
        int len = s.length();
        int pathLen = path.length();
        if (idx == len) {
            if (cnt != 0) {
                path.append(cnt);
            }
            res.add(path.toString());
            path.setLength(pathLen);
            return;
        }

        // no fail cases
        
        // change char to digit
        dfs(res, path, s, idx + 1, cnt + 1);

        // append char
        if (cnt != 0) {
            path.append(cnt);
        }
        dfs(res, path, s, idx + 1, 0);
        path.setLength(pathLen);
    }
}
```
## L488
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - 如果bfs
     - minimum -> 最短路径问题
     - V：board和hand的状态（PQ存了两个string，有点繁琐
     - E：状态转换，有向边，权值不为一（不好做
     - 一个球到空，权值为2；不可以一个球先到两个球的状态，因为这个违背了bfs 最短路径，这里增加了球
   - 这个special case：RRWWRRBBRR，hand：WB
     - 先RRWWRRBBR(W)R，得到RRWWRRBBRWR，再RRWWRRB(B)BRWR，可以清掉
     - 长度变长了
     - 很难从逻辑上handle
2. Code
```java
class Solution {
    public int solution(String board, String hand) {
        
    }

    private int dfs(String board, HashMap<String, Intger> hand) {
        int len = board.length();
        if (len == 0) {
            return 0;
        }
        if (hand.size() == 0) {
            return Integer.MAX_VALUE; // 注意越界问题
        }

        for (int i = 0; i < len; i++) {
            char ch = board.charAt(i);
            Integer cnt = hand.get(ch);
            if (cnt == null) continue;
            if (i + 1 < len && s[i+1] == ch) {
                int newCnt = cnt - 1;
                if (newCnt == 0) {
                    hand.remove(ch);
                }
                String newBoard = convert(board, i-1, i+2);
                min = Math.min(min, dfs(newBoard, hand) + 1); // 注意越界问题
                hand.put(ch, cnt);
            } else if (cnt >= 2) { // 和上面合并成一个helper function
                int newCnt = cnt - 2;
                if (newCnt == 0) {
                    hand.remove(ch);
                }
                String newBoard = convert(board, i-1, i+1);
                min = Math.min(min, dfs(newBoard, hand) + 2); // 注意越界问题
                hand.put(ch, cnt);
            }
        }
        return min;
    }

    private String convert(String board, int i, int j) {
        int len = board.length();
        while (i >= 0 && j < len) {
            char ch = board.charAt(i);
            int left = i;
            while (left >= 0 && board.charAt(left) == ch) {
                left --;
                cnt ++;
            }
            int right = j;
            while (right < len && board.charAt(right) == ch) {
                right ++;
                cnt ++;
            }
            if (cnt >= 3) {
                i = left;
                j = right;
            } else {
                break;
            }
        }
        return board.subString(0, i + 1) + board.subString(j, board.length());
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

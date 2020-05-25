## Pruning
1. dfs避免重复计算
2. 是否可以pruning？
   - 能否找到一个数据结构表示并记忆重复的内容？
   - key：搜索状态，e.g. index, String才可以pruning，而array[] array[][] 或者hashmap可能不行
   - value：dfs返回值 boolean，int可以pruning，而void（all possible solution)不行
3. 常用pruning：int[], int[][], boolean[], boolean[][], hashmap<String, in / boolean>
4. dfs + pruning有些可以直接转dp，有些不行
5. 时间复杂度：dfs+ pruning 等价于dp的level
## L139
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - dfs + boolean[] 计划存储
   - worst case：s：aaaaa...aaaab，dict: a, aa, aaa, ..., aa...a
   - 时间复杂度：每次dfs n，一共call n层，所以是n^2
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
    private boolean dfs(String s, int idx, HashSet<String> dict， Boolean[] mem) {
        if (idx == s.length()) {
            return true;
        }
        if (mem[idx] != null) return mem[idx];

        for (int i = idx; i < s.length(); i++) {
            String str = s.subString(idx, i);
            if (dict.contains(str)) {
                if (dfs(s, i, dict)) {
                    mem[idx] = true;
                    return true;
                }
            }
        }
        mem[idx] = false;
        return false;
    }
}
```
## L10
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - dfs
   - 只因为*分叉
   - 注意*和空的匹配
   - 时间复杂度：
     - worst case：aaa...aab, a*a*a* ... a*
     - 有pruning：mem的size乘以填每个位置的cost = mn * m
     - 可以dp
2. Code
```java
class Solution {
    public int solution(int[] nums) {
        
    }
    private boolean dfs(String s, int idxS, String p, int idxP) {
        int lenS = s.length();
        int lenP = p.length();

        if (idxP == p.length()) {
            return idxS == s.length();
        }

        if (idxP + 1 == lenP || p[idxP + 1] != '*') { // not *
            if (idxS < lenS && isMatched(s, idxS, p, idxP)) {
                return dfs(s, idxS + 1, p, idxP + 1);
            } else {
                return false;
            }
        } else { // is *
            int i = idxS - 1; // handle a* = 空的情况，注意下面while loop的i < idxS，避免了越界
            while (i < lenS && (i < idxS || isMatched(s, i, p, idxP))) {
                if (dfs(s, i + 1, p, idxP + 2)) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}
```
pruning:
```java
class Solution {
    public int solution(int[] nums) {
        
    }
    private boolean dfs(String s, int idxS, String p, int idxP, Boolean[][] mem) {
        int lenS = s.length();
        int lenP = p.length();

        if (idxP == p.length()) {
            return idxS == s.length();
        }
        if (mem[idxS][idxP] != null) return mem[idxS][idxP];

        if (idxP + 1 == lenP || p[idxP + 1] != '*') { // not *
            if (idxS < lenS && isMatched(s, idxS, p, idxP)) {
                mem[idxS][idxP] = dfs(s, idxS + 1, p, idxP + 1);
                return mem[idxS][idxP];
            } else {
                mem[idxS][idxP] = false;
                return false;
            }
        } else { // is *
            int i = idxS - 1; // handle a* = 空的情况，注意下面while loop的i < idxS，避免了越界
            while (i < lenS && (i < idxS || isMatched(s, i, p, idxP))) {
                if (dfs(s, i + 1, p, idxP + 2)) {
                    mem[idxS][idxP] = true;
                    return true;
                }
                i++;
            }
            mem[idxS][idxP] = false;
            return false;
        }
    }
}
```
## L140
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - dp + 反向记录路径 + dfs所有路径
2. Code
```java
class Solution {
    public List<String> wordBreakII(String s, HashSet<String> dict) {
        int len = s.length();
        Boolean[] dp = new Boolean[len + 1];
        dp[len] = true;
        
        HashMap<Intger, List<Integer>> graph = new HashMap<>();

        for (int i = len - 1; i >= 0; i--) {
            dp[i] = false;
            for (int j = i + 1; j < len; j++) {
                String str = s.subString(i, j+1);
                if (dict.contains(str) && dp[j+1]) {
                    dp[i] = true;
                    List<Integer> curs = graph.get(j+1);
                    if (curs == null) {
                        graph.put(j+1, new ArrayList<String>());
                    }
                    graph.get(j+1).add(i);
                }
            }
        }
        List<String> res = new List<>();
        dfs(res, s, new StringBuilder(), s.length(), graph);
        return res;
    }
    private void dfs(List<String> res, String s, StringBuilder path, int idx, HashMap<Integer, List<Integer>> graph) {
        if (idx == 0) {
            res.add(convert(path));
            return;
        }
        int pathLen = path.length();
        for (next: grpah.get(idx)) {
            path.append(s.subString(next, idx)+ " ");
            dfs(res, path, next, graph);
            path.setLength(pathLen);
        }
    }
}
```
### S2
1. Ideas：
   - dfs + pruning
   - 这里word break 可以做剪枝，因为只要break到底就是一个solution。而在word ladder II是求所有最短路径，也就是说跑到底了不是最短的也不要，不能剪枝
## L403
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - dfs
2. Code
```java
class Solution {
    public boolean solution(int[] stones) {
        
    }

    private boolean dfs(int[] stones, int idx, int k) {
        int len = stones.length();
        if (idx == len - 1) {
            return true;
        }
        if (idx >= len) {
            return false;
        }

        for (int i = idx + 1; i < len; i++) {
            int dist = stones[i] - stones[j];
            if (dist < k - 1) continue;
            else if (dist > k + 1) {
                break;
            } else {
                if (dfs(stones, i, dist)) {
                    return true;
                }
            }
        }
        return false;
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



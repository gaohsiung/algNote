## Pruning
1. 
## L139
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - dfs + boolean[] 计划存储
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



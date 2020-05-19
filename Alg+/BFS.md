## 1. BFS
1. 广义tree，graph，多抉择问题，各个branch都要尝试 -> 搜索问题 -> BFS, DFS
   - 尝试全部
   - 避免重复
   - 有规律不重复的遍历
2. 单抉择问题，即走了一个branch不会去尝试另外一个branch -> two pointers解决two sum
3. BFS vs DFS
   - 共同点：搜索问题，tree graph 非线性数据结构
   - 不同点：
     - 求等权重的最短路径 -> BFS
     - 不等权重(权重都要大于0）的最短路径 -> dikjstra
     - 层级搜索 -> BFS
     - 定长搜索 -> BFS
     - Others -> DFS
4. BFS实现
   - Queue，每次至多只存两层的elements
   - 最短路径
5. 套路
   - 2D matrix 最短路径：
```java
bfs(root) {
    new queue;
    queue.offer(root);
    minLen = 0;
    while(!queue.isEmpty()) {
        int size = queue.size();
        while(size-- > 0) {
            cur = queue.poll();
            usecur(cur);
            next = convert(cur);
            if (condition, notVisited){
                queue.offer(next);
            }
        }
        minLen ++; //track 最短路径
    }
}
```
## L286
1. Notes
   - 2D matrix traverse -> graph
   - each index is a vertax
   - each enighs is an edge
   - undirected
   - edge weight = 1
   - 
2. Follow up
   - null
### S1
1. Ideas：
   - BFS
   - 从所有0进行level order traverse
   - 表示2D matrix中的点，
     - int[]
     - List<Integer>
     - warp into a Cell class
     - int <- i*col + j
   - 时间复杂度：V+E+ initial
     - initial = m * n
     - Vortax = O(m * n)
     - Edge = O(m * n)
   - 空间复杂度：
     - queue -> O(m * n)
2. Code
```java
class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0]){
            throw new IllegalArgumentExcpetion();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(i*col + j);
                }
            }
        }
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(siz-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj <= col && matrix[ii][jj] == Integer.MAX_VALUE) {
                        queue.offer(ii * col + jj);
                        matrix[ii][jj] = minLen;
                    }
                }
            }
            minLen ++;
        }
    }
}
```
## L542
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - BFS 从0出发找1
   - 时间复杂度：O(m*n)
   - 空间复杂度：O(m*n)
2. Code
```java
class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        //cc

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[row][col];
        Queue<Integer> matrix = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * col + j);
                }
            }
        }
        minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj <= col &&
                        matrix[ii][jj] == 1 && result[ii][jj] == 0) { // 查重
                            queue.offer(ii * col + jj);
                            result[ii][jj] = minLen;
                    }
                }

            }
            minLen++;
        }
        return result;
    }
}
```
## L317
1. Notes
   - null
2. Follow up
   - null
### S1
1. Ideas：
   - BFS
   - 对所有1出发bfs到0得到一个matrix，sum所有，找min
   - 对于每个0来说，每次经由一个1遍历，visited只是个这个1，对于其他1来说还是没有visited过的
   - 时间复杂度：O(k*m*n) k个1
   - 空间复杂度：O(m*n)
2. Code
```java
class Solution {
    public int shortestDistanceSumToOnes(int[][] matrix) {
        // cc
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] cost = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    bfs(matrix, i, j, cost);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0){
                    min = Math.min(cost[i][j], min);
                }
            }
        }
        return min;
    }

    private void bfs(int[][] matrix, int i, int j, int[][] cost) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i* col + j);
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && matrix[ii][jj] == 0 && !(visited[ii][jj])) {
                        queue.offer(ii*col + jj);
                        visited[ii][jj] = true;
                        cost[ii][jj] += minLen
                    }
                }
            }
            minLen ++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0 && !visited[i]][j]) { 
                    //明明是0，但是并没有被visited，说明被围死了，cur的1visit不到
                    matrix[i][j] = 2; //直接改成2，即墙
                }
            }
        }
    }
}
```



## Q1 (L???)
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


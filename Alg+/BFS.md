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
5. Word ladder引生出来的套路：
   - 所有路径：DFS
   - 最短长度：dijstra，bfs，dp
   - 任意最短路径：正着搜，反着记录单一，从end还原路径
   - 所有最短路径：正着搜，反着记录所有，从end还原路径
6. 套路
   - 2D matrix 最短路径，注意查重（L286，L542，L317，L417）
   - self-construct graph (L127)
   - Tree level order traverse
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
   - 是否存在一个没有任何valid zero的case？（e.g. [[1, 2, 0]])?
     - return -1?
     - throw exception?
2. Follow up
   - L296
     - 任意点
     - 没有障碍物（可以使用数学解）
### S1
1. Ideas：
   - BFS
   - 对所有1出发bfs到0得到一个matrix，sum所有，找min
   - 对于每个0来说，每次经由一个1遍历，visited只是个这个1，对于其他1来说还是没有visited过的
   - 时间复杂度：O(k*m*n) k个1。
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
        return min == Integer.MAX_VALUE? -1: min;
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
                    //明明是0，但是并没有被visited，说明被围死了，cur的1 visit不到
                    // 这里优化的是时间复杂度big O的constant factor，worst case反而会多花点时间
                    matrix[i][j] = 2; //直接改成2，即墙
                }
            }
        }
    }
}
```
## L417
1. Notes
   - 相等也会流
2. Follow up
   - null
### S1
1. Ideas：
   - 从两个洋往回找，mn+mn
   - check 两个洋都能到，mn，可以省略
   - 时间复杂度：O(mn)
   - 搜索问题：
     - dfs：
       - 找个虚拟的点到所有两个洋的岸边 <- extra work
       - 空间复杂度：压栈（mn） + 去重（mn）
     - bfs：
       - 能够handle多个起点
       - 空间复杂度：queue （m+n）+ 去重（mn）
       - 不需要recursion
   - BFS：
     - 2 pass
     - bfs使用self和other代表当前洋和对比的洋
     - 何时check 2洋：
       - 进queue，则初始化queue和bfs中offer前都要check，两个位置
       - 出queue，只有poll出来要check，一个位置
2. Code
```java
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        //cc

        int row = matrix.length;
        int col = matrix[0].length;
        List<List> res = new ArrayList<>();
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        Queue<Intger> queue = new LinkedList<>();
        fillPacificStartPoints(matrix, pacific, queue);
        //把Pacific的start point初始化到queue，把pacific的左和上标true
        bfs(res, pacific, atlantic, queue, matrix);
        fillAtlanticStartPoints(matrix, atlantic, queue);
        bfs(res, atlantic, pacific, queue, matrix);
        return res;
    }
    private void bfs(List<List> res, boolean[][] self, boolean[][] other, Queue<Integer> queue, int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / col;
            int j = cur % col;
            if (other[i][j]) {
                res.add(Array.asList(i, j));
            }
            for (int[] dir: DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj <= col && matrix[i][j] <= matrix[ii][jj]) {
                    queue.offer(ii*col + jj);
                    self[ii][jj] = true;
                }
            }
        }
    }
}
```
## L127
1. Notes
   - 给的是dictionary，这里是个```List<String>```，不是很好；最好hashset（没有重复），O(1)查找Hashmap。
   - 同时dictionary的size很大，不要for loop或者traverse dictionary。
   - clarify：
     - 可不可呢找不到？
     - start和end相等？
     - start直接convert到end，没有使用任何dictionary单词？
2. Follow up
   - L126 找到所有最短路径
     - 使用hashmap存图```HashMap<From_word, List<To_word>> graph```
     - bfs中同层的查重：不能像L127直接remove，因为要保留多个最短路径，所以同层的remove要在遍历完之后再整体remove。同时，由于queue poll出来transform出相同的值，这些transform的edge都要保留，但又不能往queue里add 重复
     - 所以，要避免queue里offer多个相同的这个下层的重复的值，但是要保留transform边的信息，即，当poll出一个新的值，先看看levelvisited里面有没有？没的话，说明这个新的是没被visit过，要加到queue里，同时graph里没有，要create新的key value pair；有的话，说明之前加到queue了，我们不能加到queue，但是我们可以更新graph，因为有另一条边连到这个之前存在的值了
     - 有了hashmap的graph，还原所有路径
       - DFS：
         - 时间复杂度：O(V+E) + O(deep copy)只deep copy res list
         - 空间复杂度：O(L)（栈空间） + O(resList)
       - BFS：
         - {A}
         - {A, B}, {A, C}
         - {A, B, E}, {A, B, F}, {A, C, G}
         - ....
         - 时间复杂度：O(V+E) + O(deep copy)，每个level都要deep copy
         - 空间复杂度：O(2^n)(未交叉，交叉更加爆炸)
     - 优化：使用hashmap存的时候，不要key是cur而val是next，可以key是next，而val是cur。这样最后还原过程时，直接从end出发，由于是从start遍历，所以end出发的所有都能够回到start！
     - 创建图必须bfs，还原过程必须dfs
     - 时间复杂度：创建图+recover path = n^2
       - 创建图：V+E
       - recover path：V+E+deepcopy
       - V：n，dict size
       - E：n^2
     - 也可以类似S2来做，两个bfs往中间走，还原是中间往两边还原
```java
class Solution {
    public List<List<String>> wordLadderII(String start, String end, List<String> dict) {
        //cc
        List<List<String>> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        dict.remove(start);
        HashMap<String, List<String>> graph = new HashMap<>();
        boolean isOver = false; // check是否end word被检查，被check到了就不用再transform了，直接还原出所有的list return 出来了
    
        while(!queue.isEmpty()) {
            int size = queue.size();
            HashSet<String> levelVisited = new HashSet<>();
            while(size-- > 0) {
                String cur = queue.poll();
                List<String> nexts = transform(cur, dict);
                for (String next: nexts) {
                    if (next.equals(end)) { // check是否check到end
                        isOver = true;
                    }
                    if (!dict.contains(next)) { //之前层已经poll过了，已经不是最短了，要剪枝
                        continue;
                    }
                    if (levelVisited.add(next)) {
                        queue.offer(next);
                        graph.put(cur, newArrayList<>()); // 反向存边：graph.put(next, newArrayList<>())
                    }
                    graph.get(cur).add(next);  // 反向存边：graph.get(next).add(cur);            
                }
            }
            dict.removeAll(levelVisited);
            if (isOver) { // restore all paths
                List<String> path = new LinkedList<>();
                path.add(start);// 反向存边：path.add(end)
                dfs(res, graph, start, end, path);  // 反向存边：dfs(res, graph, end, start, path);
                return res;
            }
        }
        return -1; // 找不到 or throw new IllegalStateException("not found");
    }

    private void dfs(List<List<String>> res, HashMap<String, List<String>> graph, String cur, String end, List<String> path) {
        if(cur.equals(end)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String next: graph.get(cur)) {
            path.add(next); // 反向存边：path.add(0, next)
            dfs(res, graph, next, end, path);
            path.remove(path.size() - 1); // 反向存边：path.remove(0)
        }
    }
}
```
   - Word Ladder III only output any one of the shortest paths
     - 基于S1，使用一个hashmap记录next到cur的边，最后通过while loop来还原这个shortest path
### S1
1. Ideas：
   - 在图上bfs
   - 最短路径
   - 分叉特性
   - 在图上的搜索问题，点是word，边是能够convert的关系，边是双向的，无向边，边的权值都是1
   - 在图上从startword到endword的最短距离问题
   - 使用hashmap表示图，快而且简洁，```HashMap<From_word, List<To_word>> graph```
   - transform: 对每个word中的每个char，for loop这个char的所有可能性，check 是否dict contains。避免traverse dict
   - 时间复杂度：
     - V = O(n)
     - E = O(n^2)，worst的话所有单词都可能convert，所以是两两连接。（Edge的个数是介于O(V) ~ O(V^2)，O(V)指V个点有V-1个边，不能再少了，再少就断了；O(V^2)指的是V个点两两都连接，V choose 2，所以是O(V^2)级别的）
     - 所以，O(V+E) = O(n^2)
2. Code
```java
class Solution {
    public int wordLadder(String start, String end, List<String> dict) {
        //cc

        Queue<String> queue = new LinkedList<>();
        // Set<String> visited; 可以使用remove 遍历过的word from dict，如果不让改dict，可以deep copy一个
        queue.offer(start);
        dict.remove(start);
        int minLen = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String cur = queue.poll();
                List<String> nexts = transform(cur, dict);
                for (String next: nexts) {
                    if (next.equals(end)){
                        return minLen + 1;
                    }
                    queue.offer(next);
                    dictionary.remove(next);
                    // 这里remove了next，之后当层其他的cur就无法转换到这个next了，实现提前剪枝，因为当层我们只要保证至少有一个能到达这个next就可以了，而额外使用一个set的话还得while loop那些个curs，多了些步骤
                }
            }
            minLen++;
        }
        return -1; // 找不到 or throw new IllegalStateException("not found");
    }
}
```
### S2
1. Ideas：
   -  分别从start和end两边同时bfs
   -  如果两边bfs过程中的两个”queue"中出现相同的element，则此时就是最短路径可以从start到end
   -  使用hashset作为bfs中的“queue"，主要是因为能O(1)时间能check另一个是否contain
   -  由于hashset无法保证FIFO，所以需要一个辅助的另一个hashset来完成curlevel和nextlevel的遍历
   -  两个bfs的推进取决于谁的size小，谁推进
   -  类似start end两边往中间走，当dict删完了说明start end之间无法转换
   -  时间复杂度：一样，只减了一些constant factor
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




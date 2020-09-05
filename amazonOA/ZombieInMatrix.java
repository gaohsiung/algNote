import java.util.*;

public class ZombieInMatrix {
    public static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int minDays(int[][] grid) {
        // c.c.

        Queue<Integer> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int target = row * col;
        int cnt = 0, res = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    q.offer(i*col+j);
                    cnt++;
                }
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            if(cnt == target)
                return res;
            while (size-- > 0) {
                int cur = q.poll();
                int r = cur / col;
                int c = cur % col;
                for(int[] dir : DIRECTIONS) {
                    int rr = r + dir[0];
                    int cc = c + dir[1];
                    if(rr >=0 && rr < row && cc >=0 && cc < col && grid[rr][cc] == 0) {
                        cnt++;
                        q.offer(rr*col + cc);
                        grid[rr][cc] = 1;
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
        System.out.println(minDays(grid));
    }
}

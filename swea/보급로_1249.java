import java.io.*;
import java.util.*;
 
public class Solution {
    static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static final class Direction {
        int y, x;
 
        Direction(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
 
    static final Direction[] DIRECTIONS = { new Direction(1, 0), new Direction(-1, 0), new Direction(0, 1),
        new Direction(0, -1) };
 
    static int N;
    static int[][] map = new int[100][100];
 
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(BR.readLine().trim());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(BR.readLine().trim());
            for (int y = 0; y < N; y++) {
                int[] mapX = Arrays.stream(BR.readLine().trim().split("")).mapToInt(Integer::parseInt).toArray();
                for (int x = 0; x < N; x++) {
                    map[y][x] = mapX[x];
                }
            }
 
            boolean[][] visited = new boolean[100][100];
            int[][] count = new int[100][100];
            Queue<Direction> que = new LinkedList<>();
            que.add(new Direction(0, 0));
 
            while (!que.isEmpty()) {
                Direction cur = que.poll();
                visited[cur.y][cur.x] = true;
 
                for (Direction d : DIRECTIONS) {
                    Direction next = new Direction(cur.y + d.y, cur.x + d.x);
                    if (!canMove(next)) {
                        continue;
                    }
                    if (cur.y == 0 && cur.x == 0) {
                        visited[next.y][next.x] = true;
                        count[next.y][next.x] = map[next.y][next.x];
                        que.add(next);
                        continue;
                    }
 
                    if (!visited[next.y][next.x] && map[next.y][next.x] == 0) {
                        visited[next.y][next.x] = true;
                        count[next.y][next.x] = count[cur.y][cur.x];
                        que.add(next);
                    } else if (!visited[next.y][next.x]
                        || count[next.y][next.x] > count[cur.y][cur.x] + map[next.y][next.x]) {
                        visited[next.y][next.x] = true;
                        count[next.y][next.x] = count[cur.y][cur.x] + map[next.y][next.x];
                        que.add(next);
                    }
                }
            }
            System.out.printf("#%d %d\n", testCase, count[N - 1][N - 1]);
        }
    }
 
    public static boolean canMove(final Direction next) {
        return next.y >= 0 && next.y < N && next.x >= 0 && next.x < N;
    }
}

import java.io.*;
import java.util.*;
 
class Solution {
    static class Direction {
        int y, x;
 
        public Direction(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
    }
 
    static final int[][] DIRCTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int[][] TYPETUNNEL = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 0, 1, 0}
    };
 
    static int[][] map;
    static boolean[][] visited;
    static int N, M, R, C, L;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
 
            map = new int[N][M];
            visited = new boolean[N][M];
 
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }
 
            bw.write("#" + testCase + " " + BFS() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
 
    private static int BFS() {
        int result = 1, time = 1;
        Queue<Direction> que = new ArrayDeque<>();
        que.add(new Direction(R, C));
        visited[R][C] = true;
 
        while (!que.isEmpty()) {
            if (time == L) {
                break;
            }
            int size = que.size();
            while (size > 0) {
                Direction cur = que.poll();
                int[] curDir = TYPETUNNEL[map[cur.y][cur.x]];
 
                for (int d = 0; d < curDir.length; d++) {
                    if (curDir[d] == 0) {
                        continue;
                    }
                    int nextY = cur.y + DIRCTIONS[d][0];
                    int nextX = cur.x + DIRCTIONS[d][1];
                    if (!canMove(nextY, nextX) || visited[nextY][nextX] || map[nextY][nextX] == 0) {
                        continue;
                    }
                    int[] nextDirs = TYPETUNNEL[map[nextY][nextX]];
                    int opposite = (d % 2 == 0) ? d + 1 : d - 1;
 
                    if (nextDirs[opposite] == 1) {
                        visited[nextY][nextX] = true;
                        que.add(new Direction(nextY, nextX));
                        result++;
                    }
                }
                size--;
            }
            time++;
        }
        return result;
    }
 
    static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}


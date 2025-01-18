// BFS
import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[][] bugs;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            bugs = new int[K][2];

            for (int idx = 0; idx < K; idx++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
                bugs[idx] = new int[]{y, x};
            }

            int result = bfs();
            System.out.println(result);
        }
        br.close();
    }

    static int bfs() {
        boolean[][] visited = new boolean[N][M];
        int count = 1;
        Queue<int[]> que = new ArrayDeque<>();
        visited[bugs[0][0]][bugs[0][1]] = true;
        que.add(bugs[0]);

        for (int[] bug : bugs) {
            if (!visited[bug[0]][bug[1]]) {
                visited[bug[0]][bug[1]] = true;
                que.add(bug);
                count++;
            }

            while (!que.isEmpty()) {
                int[] cur = que.poll();
                visited[cur[0]][cur[1]] = true;

                for (int[] d : dirs) {
                    int nextY = cur[0] + d[0];
                    int nextX = cur[1] + d[1];
                    if (!canMove(nextX, nextY) || visited[nextY][nextX] || map[nextY][nextX] == 0) {
                        continue;
                    }
                    visited[nextY][nextX] = true;
                    que.add(new int[]{nextY, nextX});
                }
            }
        }

        return count;
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < M && x >= 0 && x < N;
    }
}

// DFS
import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[][] bugs;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            bugs = new int[K][2];
            visited = new boolean[N][M];

            for (int idx = 0; idx < K; idx++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
                bugs[idx] = new int[]{y, x};
            }
            int result = 0;
            for (int[] bug : bugs) {
                if (!visited[bug[0]][bug[1]]) {
                    result++;
                }
                dfs(bug);
            }
            System.out.println(result);
        }
        br.close();
    }

    static void dfs(int[] curBug) {
        visited[curBug[0]][curBug[1]] = true;
        for (int[] d : dirs) {
            int nextY = curBug[0] + d[0];
            int nextX = curBug[1] + d[1];
            if (!canMove(nextY, nextX) || visited[nextY][nextX] || map[nextY][nextX] == 0) {
                continue;
            }
            visited[nextY][nextX] = true;
            dfs(new int[]{nextY, nextX});
        }
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}

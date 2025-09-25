import java.io.*;
import java.util.*;

public class Main {
    static int M, N, result = 0;
    static int[][] map, dp;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1];

        for (int y = 1; y <= M; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                dp[y][x] = -1;
            }
        }

        bw.write(dfs(1, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int y, int x) {
        if (y == M && x == N) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        for (int[] dir : directions) {
            int nextY = y + dir[0];
            int nextX = x + dir[1];
            if (canMove(nextY, nextX)) {
                if (map[nextY][nextX] < map[y][x]) {
                    dp[y][x] += dfs(nextY, nextX);
                }
            }
        }
        return dp[y][x];
    }

    private static boolean canMove(int y, int x) {
        return y >= 1 && y <= M && x >= 1 && x <= N;
    }
}


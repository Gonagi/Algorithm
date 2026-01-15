import java.io.*;
import java.util.*;

public class Main {
    static int[][] map, dp, directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int max, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                dp[y][x] = 0;
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                max = Math.max(max, dfs(y, x));
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int dfs(int y, int x) {
        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        dp[y][x] = 1;
        for (int[] dir : directions) {
            int nextY = y + dir[0];
            int nextX = x + dir[1];
            if (canMove(nextY, nextX) && map[y][x] < map[nextY][nextX]) {
                dp[y][x] = Math.max(dp[y][x], dfs(nextY, nextX) + 1);
            }
        }

        return dp[y][x];
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}


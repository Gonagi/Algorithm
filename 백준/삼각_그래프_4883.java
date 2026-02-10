import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1;; testCase++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int[][] map = new int[N][3];
            int[][] dp = new int[N][3];
            for (int y = 0; y < N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < 3; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = 1_001;
            dp[0][1] = map[0][1];
            dp[0][2] = map[0][1] + map[0][2];
            for (int y = 1; y < N; y++) {
                dp[y][0] = Math.min(dp[y - 1][0], dp[y - 1][1]) + map[y][0];
                dp[y][1] = Math.min(dp[y][0], Math.min(Math.min(dp[y - 1][0], dp[y - 1][1]), dp[y - 1][2])) + map[y][1];
                dp[y][2] = Math.min(dp[y][1], Math.min(dp[y - 1][1], dp[y - 1][2])) + map[y][2];
            }
            sb.append(testCase).append(". ").append(dp[N - 1][1]).append('\n');
        }
        System.out.println(sb);
        br.close();

    }
}


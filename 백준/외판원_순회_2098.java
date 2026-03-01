import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] W;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new long[N][1 << N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 1));
        br.close();
    }

    private static long dfs(int cur, int visited) {
        if (visited == (1 << N) - 1) {
            if (W[cur][0] == 0) {
                return Integer.MAX_VALUE;
            }
            return W[cur][0];
        }

        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        dp[cur][visited] = Integer.MAX_VALUE;
        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) != 0 || W[cur][next] == 0) {
                continue;
            }
            long cost = W[cur][next] + dfs(next, (visited | (1 << next)));
            dp[cur][visited] = Math.min(dp[cur][visited], cost);
        }

        return dp[cur][visited];
    }
}


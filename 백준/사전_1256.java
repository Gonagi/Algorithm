import java.io.*;
import java.util.*;

public class Main {
    private static long[][] dp;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        dp = new long[N + 1][M + 1];
        for (int idx = 1; idx <= M; idx++) {
            dp[0][idx] = 1;
        }
        for (int idx = 1; idx <= N; idx++) {
            dp[idx][0] = 1;
        }

        for (int idx = 1; idx <= N; idx++) {
            for (int idx2 = 1; idx2 <= M; idx2++) {
                dp[idx][idx2] = Math.min(1_000_000_000, dp[idx - 1][idx2] + dp[idx][idx2 - 1]);
            }
        }

        if (K > dp[N][M]) {
            System.out.println(-1);
            return;
        }

        findStr(N, M, K);
        System.out.println(sb);
    }

    private static void findStr(int aCount, int zCount, int K) {
        if (aCount == 0) {
            for (int idx = 0; idx < zCount; idx++) {
                sb.append('z');
            }
            return;
        }

        if (zCount == 0) {
            for (int idx = 0; idx < aCount; idx++) {
                sb.append('a');
            }
            return;
        }

        if (dp[aCount - 1][zCount] < K) {
            sb.append('z');
            findStr(aCount, zCount - 1, K - (int) dp[aCount - 1][zCount]);
        } else {
            sb.append('a');
            findStr(aCount - 1, zCount, K);
        }
    }
}


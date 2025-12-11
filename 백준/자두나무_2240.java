import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] drop = new int[T + 1];
        for (int idx = 1; idx <= T; idx++) {
            drop[idx] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[T + 1][W + 1];
        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                dp[t][w] = dp[t - 1][w];

                int pos = w % 2 == 0 ? 1 : 2;

                if (drop[t] == pos)
                    dp[t][w]++;

                if (w > 0) {
                    dp[t][w] = Math.max(dp[t][w], dp[t - 1][w - 1] + (drop[t] == pos ? 1 : 0));
                }
            }
        }

        int ans = 0;
        for (int w = 0; w <= W; w++) {
            ans = Math.max(ans, dp[T][w]);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}


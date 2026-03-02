import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[101][101][101];
        dp[1][1][1] = 1;
        dp[2][1][2] = dp[2][2][1] = 1;

        for (int n = 3; n <= N; n++) {
            for (int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    dp[n][l][r] += dp[n - 1][l - 1][r] % 1_000_000_007;
                    dp[n][l][r] += dp[n - 1][l][r - 1] % 1_000_000_007;
                    dp[n][l][r] += dp[n - 1][l][r] * (n - 2) % 1_000_000_007;
                    dp[n][l][r] %= 1_000_000_007;
                }
            }
        }

        System.out.println(dp[N][L][R]);
        br.close();
    }
}


import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[30][30];

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            bw.write(comb(M, N) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int comb(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}


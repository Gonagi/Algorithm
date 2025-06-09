import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[4][100001];

        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[2][2] = 1;
        dp[1][3] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;

        for (int idx = 4; idx <= 10001; idx++) {
            dp[1][idx] = dp[1][idx - 1];
            dp[2][idx] = dp[1][idx - 2] + dp[2][idx - 2];
            dp[3][idx] = dp[1][idx - 3] + dp[2][idx - 3] + dp[3][idx - 3];
        }

        for (int idx = 0; idx < T; idx++) {
            int n = Integer.parseInt(br.readLine());
            bw.write((dp[1][n] + dp[2][n] + dp[3][n]) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


import java.io.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 1;
        for (int idx = 4; idx <= 5000; idx += 2) {
            for (int idx2 = 0; idx2 <= idx - 2; idx2 += 2) {
                dp[idx] = (dp[idx] + (dp[idx2] * dp[idx - 2 - idx2]) % 1_000_000_007) % 1_000_000_007;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < T; idx++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(dp[num] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


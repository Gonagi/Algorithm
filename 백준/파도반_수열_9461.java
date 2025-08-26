import java.io.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[101];

        dp[1] = dp[2] = dp[3] = 1;

        for (int idx = 4; idx <= 100; idx++) {
            dp[idx] = dp[idx - 3] + dp[idx - 2];
        }

        int T = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < T; idx++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}


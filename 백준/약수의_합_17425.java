import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] A = new long[1_000_001];
        long[] dp = new long[1_000_001];

        for (int num = 1; num <= 1_000_000; num++) {
            for (int n = num; n <= 1_000_000; n += num) {
                A[n] += num;
            }
        }
        for (int num = 1; num <= 1_000_000; num++) {
            dp[num] += dp[num - 1] + A[num];
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}


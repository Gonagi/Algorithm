import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        for (int idx = 3; idx <= N; idx++) {
            dp[idx] = (dp[idx - 2] + dp[idx - 1]) % 15746;
        }
        System.out.println(dp[N]);
        br.close();
    }
}


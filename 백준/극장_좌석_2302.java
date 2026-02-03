import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[41];
        dp[0] = 1;
        dp[1] = 1;
        for (int idx = 2; idx <= N; idx++) {
            dp[idx] = dp[idx - 2] + dp[idx - 1];
        }

        int answer = 1;
        int M = Integer.parseInt(br.readLine());
        int prevNum = 0;
        for (int idx = 0; idx < M; idx++) {
            int num = Integer.parseInt(br.readLine());
            answer *= dp[num - prevNum - 1];
            prevNum = num;
        }
        answer *= dp[N - prevNum];

        System.out.println(answer);
        br.close();
    }
}


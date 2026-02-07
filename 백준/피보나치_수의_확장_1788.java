import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1_000_001];
        dp[1] = 1;
        for (int idx = 2; idx <= 1_000_000; idx++) {
            dp[idx] = (dp[idx - 1] + dp[idx - 2]) % 1_000_000_000;
        }

        boolean check = false;
        if (n < 0) {
            n *= -1;
            check = true;
        }

        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            sb.append(0).append('\n').append(0);
        } else if (n % 2 == 0) {
            if (check) {
                sb.append(-1).append('\n').append(dp[n]);
            } else {
                sb.append(1).append('\n').append(dp[n]);
            }
        } else {
            sb.append(1).append('\n').append(dp[n]);
        }
        System.out.println(sb);
        br.close();
    }
}


import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] children = new int[N];
        int[] dp = new int[N];
        for (int idx = 0; idx < N; idx++) {
            children[idx] = Integer.parseInt(br.readLine());
            dp[idx] = 1;
        }

        int max = 0;
        for (int cur = 0; cur < N; cur++) {
            for (int prev = 0; prev < cur; prev++) {
                if (children[cur] > children[prev]) {
                    dp[cur] = Math.max(dp[cur], dp[prev] + 1);
                }
            }
            max = Math.max(max, dp[cur]);
        }
        System.out.println(N - max);
        br.close();
    }
}


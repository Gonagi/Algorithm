import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] children = new int[N];
        int[] dp = new int[N];
        for (int idx = 0; idx < N; idx++) {
            children[idx] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        for (int idx = 0; idx < N; idx++) {
            dp[idx] = 1;
            for (int idx2 = 0; idx2 < idx; idx2++) {
                if (children[idx2] < children[idx] && dp[idx] < dp[idx2] + 1) {
                    dp[idx] = dp[idx2] + 1;
                    max = Math.max(max, dp[idx]);
                }
            }
        }

        bw.write((N - max) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}


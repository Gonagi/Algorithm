import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N + 1];
        dp[1] = true;
        if (N == 2) {
            dp[2] = false;
        } else if (N >= 3) {
            for (int idx = 3; idx <= N; idx++) {
                dp[idx] = dp[idx - 2];
            }
        }

        if (dp[N]) {
            bw.write("SK\n");
        } else {
            bw.write("CY\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


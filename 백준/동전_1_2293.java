import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] inputs = new int[n];
        for (int idx = 0; idx < n; idx++) {
            int input = Integer.parseInt(br.readLine());
            inputs[idx] = input;
        }
        Arrays.sort(inputs);

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int coin : inputs) {
            for (int cur = coin; cur <= k; cur++) {
                dp[cur] += dp[cur - coin];
            }
        }

        bw.write(String.valueOf(dp[k]));
        bw.flush();
        br.close();
        bw.close();
    }
}


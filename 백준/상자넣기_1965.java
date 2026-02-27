import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
            dp[idx] = 1;
        }

        int result = 1;
        for (int idx = 1; idx < n; idx++) {
            for (int idx2 = idx - 1; idx2 >= 0; idx2--) {
                if (input[idx2] < input[idx]) {
                    dp[idx] = Math.max(dp[idx], dp[idx2] + 1);
                }
            }
            result = Math.max(result, dp[idx]);
        }

        System.out.println(result);
        br.close();
    }
}


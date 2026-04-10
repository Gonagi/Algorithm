import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] people = new int[n + 1];
        int[] sum = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= n; idx++) {
            people[idx] = Integer.parseInt(st.nextToken());
            sum[idx] += people[idx];
            if (idx != 1) {
                sum[idx] += sum[idx - 1];
            }
        }
        int m = Integer.parseInt(br.readLine());

        int[][] dp = new int[4][n + 1];
        for (int k = 1; k <= 3; k++) {
            for (int i = m; i <= n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], dp[k - 1][i - m] + (sum[i] - sum[i - m]));
            }
        }

        System.out.println(dp[3][n]);
        br.close();
    }
}


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            number[idx] = Integer.parseInt(st.nextToken());
        }

        int start = number[0];
        long[][] dp = new long[21][N];
        dp[start][0] = 1L;

        for (int idx = 1; idx < N - 1; idx++) {
            for (int idx2 = 0; idx2 <= 20; idx2++) {
                if (dp[idx2][idx - 1] > 0) {
                    if (idx2 + number[idx] <= 20) {
                        dp[idx2 + number[idx]][idx] += dp[idx2][idx - 1];
                    }
                    if (idx2 - number[idx] >= 0) {
                        dp[idx2 - number[idx]][idx] += dp[idx2][idx - 1];
                    }
                }
            }
        }
        int end = number[N - 1];
        System.out.println(dp[end][N - 2]);
        br.close();
    }
}


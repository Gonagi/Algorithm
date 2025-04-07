import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] V = new int[N + 1];
            int[] C = new int[N + 1];

            for (int idx = 1; idx <= N; idx++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                V[idx] = v;
                C[idx] = c;
            }

            int[][] DP = new int[N + 1][K + 1];
            for (int n = 1; n <= N; n++) {
                for (int k = 1; k <= K; k++) {
                    if (V[n] <= k) {
                        DP[n][k] = Math.max(DP[n - 1][k], DP[n - 1][k - V[n]] + C[n]);
                    } else {
                        DP[n][k] = DP[n - 1][k];
                    }
                }
            }
            bw.write("#" + testCase + " " + DP[N][K] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


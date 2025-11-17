import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N + 1];
        int[][] dp = new int[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= N; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
        }

        for (int idx = 1; idx <= N; idx++) {
            dp[idx][idx] = 1;
        }

        for (int idx = 1; idx < N; idx++) {
            if (input[idx] == input[idx + 1]) {
                dp[idx][idx + 1] = 1;
            }
        }

        for (int idx = 3; idx <= N; idx++) {
            for (int idx2 = 1; idx2 + idx - 1 <= N; idx2++) {
                int idx3 = idx2 + idx - 1;
                if (input[idx2] == input[idx3] && dp[idx2 + 1][idx3 - 1] == 1) {
                    dp[idx2][idx3] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            if (dp[S][E] == 1) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


package Daily08.geonhak;

import java.io.*;
import java.util.*;

public class Main_12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            st = new StringTokenizer(br.readLine());
            W[idx] = Integer.parseInt(st.nextToken());
            V[idx] = Integer.parseInt(st.nextToken());
        }

        int[][] DP = new int[N + 1][K + 1];
        for (int idx = 1; idx <= N; idx++) {
            for (int w = 1; w <= K; w++) {
                if (W[idx] <= w) {
                    DP[idx][w] = Math.max(DP[idx - 1][w], DP[idx - 1][w - W[idx]] + V[idx]);
                } else {
                    DP[idx][w] = DP[idx - 1][w];
                }
            }
        }

        bw.write(DP[N][K] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}


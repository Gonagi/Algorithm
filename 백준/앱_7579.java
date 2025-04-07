package Daily08.geonhak;

import java.io.*;
import java.util.*;

public class Main_7579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ms = new int[N + 1];
        int[] cs = new int[N + 1];
        StringTokenizer memoriesInput = new StringTokenizer(br.readLine());
        StringTokenizer valuesInput = new StringTokenizer(br.readLine());

        int totalCost = 0;
        for (int idx = 1; idx <= N; idx++) {
            ms[idx] = Integer.parseInt(memoriesInput.nextToken());
            cs[idx] = Integer.parseInt(valuesInput.nextToken());
            totalCost += cs[idx];
        }

        int[][] DP = new int[N + 1][totalCost + 1];

        for (int idx = 1; idx <= N; idx++) {
            for (int c = 0; c <= totalCost; c++) {
                if (cs[idx] <= c) {
                    DP[idx][c] = Math.max(DP[idx - 1][c], DP[idx - 1][c - cs[idx]] + ms[idx]);
                } else {
                    DP[idx][c] = DP[idx - 1][c];
                }
            }
        }

        int result = 0;
        for (int idx = 1; idx <= totalCost; idx++) {
            if (M <= DP[N][idx]) {
                result = idx;
                break;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}


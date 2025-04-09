package Daily10.geonhak;

import java.io.*;
import java.util.*;

public class Solution_1263 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            map = new int[N + 1][N + 1];

            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                    if (y != x && map[y][x] == 0) {
                        map[y][x] = 1000;
                    }
                }
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                    }
                }
            }

            int max = Integer.MAX_VALUE;
            for (int y = 1; y <= N; y++) {
                int sum = 0;
                for (int x = 1; x <= N; x++) {
                    sum += map[y][x];
                }
                max = Math.min(max, sum);
            }
            bw.write("#" + testCase + " " + max + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


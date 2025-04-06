import java.io.*;
import java.util.*;

class Solution {
    static int[][] map, profit;
    static int N, M, C, maxProfit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            profit = new int[N][N];
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x <= N - M; x++) {
                    profit[y][x] = getMaxSubset(map[y], x, 0, 0, 0);
                }
            }

            maxProfit = 0;

            for (int y1 = 0; y1 < N; y1++) {
                for (int x1 = 0; x1 <= N - M; x1++) {
                    for (int y2 = y1; y2 < N; y2++) {
                        int startX = (y1 == y2) ? x1 + M : 0;
                        for (int x2 = startX; x2 <= N - M; x2++) {
                            int total = profit[y1][x1] + profit[y2][x2];
                            maxProfit = Math.max(maxProfit, total);
                        }
                    }
                }
            }
            bw.write("#" + testCase + " " + maxProfit + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int getMaxSubset(int[] mapX, int start, int sum, int value, int idx) {
        if (sum > C) {
            return 0;
        }
        if (idx == M) {
            return value;
        }

        int include = getMaxSubset(mapX, start, sum + mapX[start + idx], value + mapX[start + idx] * mapX[start + idx],
                idx + 1);
        int exclude = getMaxSubset(mapX, start, sum, value, idx + 1);
        return Math.max(include, exclude);
    }
}


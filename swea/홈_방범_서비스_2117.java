import java.io.*;
import java.util.*;

class Solution {
    static int N, M, result;
    static boolean[][] map;
    static int[] operationCosts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        operationCosts = new int[22];

        for (int k = 1; k < 22; k++) {
            operationCosts[k] = k * k + (k - 1) * (k - 1);
        }

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;
            map = new boolean[N][N];

            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = st.nextToken().equals("1") ? true : false;
                }
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    check(y, x);
                }
            }

            bw.write("#" + testCase + " " + result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void check(int y, int x) {
        for (int k = 1; k <= N + 1; k++) {
            int count = 0;
            for (int r = y - k + 1; r < y + k; r++) {
                for (int c = x - k + 1; c < x + k; c++) {
                    int dist = Math.abs(y - r) + Math.abs(x - c);
                    if (dist < k && canMove(r, c) && map[r][c]) {
                        count++;
                    }
                }
            }

            if (count * M >= operationCosts[k]) {
                result = Math.max(result, count);
            }
        }

    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}


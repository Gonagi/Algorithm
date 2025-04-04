import java.io.*;
import java.util.*;

class Main {
    static int N, count;
    static boolean[][] map;
    static int[][][] DP;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        count = 0;
        map = new boolean[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                map[y][x] = st.nextToken().equals("1") ? false : true;
            }
        }
        DP = new int[3][N + 1][N + 1];
        DP[0][1][2] = 1;

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (!map[y][x]) {
                    continue;
                }
                DP[0][y][x] += DP[0][y][x - 1] + DP[2][y][x - 1];
                DP[1][y][x] += DP[1][y - 1][x] + DP[2][y - 1][x];
                if (!map[y - 1][x] || !map[y][x - 1]) {
                    continue;
                }
                DP[2][y][x] += DP[0][y - 1][x - 1] + DP[1][y - 1][x - 1] + DP[2][y - 1][x - 1];
            }
        }

        bw.write((DP[0][N][N] + DP[1][N][N] + DP[2][N][N]) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}


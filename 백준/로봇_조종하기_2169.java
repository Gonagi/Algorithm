import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = map[1][1];
        for (int x = 2; x <= M; x++) {
            dp[1][x] = dp[1][x - 1] + map[1][x];
        }

        for (int y = 2; y <= N; y++) {
            int[] left = new int[M + 1];
            int[] right = new int[M + 1];

            left[1] = dp[y - 1][1] + map[y][1];
            for (int x = 2; x <= M; x++) {
                left[x] = Math.max(dp[y - 1][x], left[x - 1]) + map[y][x];
            }

            right[M] = dp[y - 1][M] + map[y][M];
            for (int x = M - 1; x >= 1; x--) {
                right[x] = Math.max(dp[y - 1][x], right[x + 1]) + map[y][x];
            }

            for (int x = 1; x <= M; x++) {
                dp[y][x] = Math.max(left[x], right[x]);
            }
        }

        bw.write(dp[N][M] + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}


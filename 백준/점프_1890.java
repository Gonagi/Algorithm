import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (dp[y][x] == 0) {
                    continue;
                }
                if (map[y][x] == 0) {
                    continue;
                }

                int jump = map[y][x];
                if (x + jump < N) {
                    dp[y][x + jump] += dp[y][x];
                }
                if (y + jump < N) {
                    dp[y + jump][x] += dp[y][x];
                }
            }
        }

        bw.write(String.valueOf(dp[N - 1][N - 1]));
        bw.flush();
        bw.close();
        br.close();
    }
}


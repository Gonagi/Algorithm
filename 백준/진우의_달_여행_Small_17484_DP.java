import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M][3];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[y][x], Integer.MAX_VALUE);
            }
        }

        for (int x = 0; x < M; x++) {
            dp[0][x][0] = map[0][x];
            dp[0][x][1] = map[0][x];
            dp[0][x][2] = map[0][x];
        }

        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                for (int d = 0; d < 3; d++) {
                    int nx = x + (d - 1);
                    if (nx < 0 || nx >= M)
                        continue;

                    for (int prev = 0; prev < 3; prev++) {
                        if (prev == d)
                            continue;
                        if (dp[y - 1][nx][prev] != Integer.MAX_VALUE) {
                            dp[y][x][d] = Math.min(dp[y][x][d], dp[y - 1][nx][prev] + map[y][x]);
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int x = 0; x < M; x++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[N - 1][x][d]);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];
        int[][] dp = new int[n][m];

        int max = 0;
        for (int y = 0; y < n; y++) {
            String input = br.readLine();
            for (int x = 0; x < m; x++) {
                map[y][x] = input.charAt(x) == '0' ? false : true;
                if (map[y][x]) {
                    if (y == 0 || x == 0) {
                        dp[y][x] = 1;
                    } else {
                        dp[y][x] = Math.min(Math.min(dp[y - 1][x], dp[y][x - 1]), dp[y - 1][x - 1]) + 1;
                    }
                }
                max = Math.max(max, dp[y][x]);
            }
        }

        bw.write(String.valueOf(max * max));
        bw.flush();
        br.close();
        bw.close();
    }
}


import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp = new int[61][61][61];
    static int[][] attacks = {
            {9, 3, 1}, {9, 1, 3},
            {3, 1, 9}, {3, 9, 1},
            {1, 3, 9}, {1, 9, 3}
    };
    static int N;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] health = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            health[idx] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                for (int k = 0; k < 61; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        bw.write(String.valueOf(dfs(health[0], health[1], health[2])));
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int a, int b, int c) {
        a = Math.max(a, 0);
        b = Math.max(b, 0);
        c = Math.max(c, 0);

        if (a == 0 && b == 0 && c == 0) {
            return 0;
        }
        
        if (dp[a][b][c] != -1) {
            return dp[a][b][c];
        }

        int result = Integer.MAX_VALUE;
        for (int[] atk : attacks) {
            result = Math.min(result, dfs(a - atk[0], b - atk[1], c - atk[2]) + 1);
        }

        return dp[a][b][c] = result;
    }
}


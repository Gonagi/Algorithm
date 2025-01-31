import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[3][N + 1];
			int[][] dp = new int[3][N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int idx = 1; idx <= N; idx++) {
				map[1][idx] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int idx = 1; idx <= N; idx++) {
				map[2][idx] = Integer.parseInt(st.nextToken());
			}
			StringBuilder sb = new StringBuilder();
			if (N == 1) {
				sb.append(Math.max(map[1][1], map[2][1]));
			} else {
				dp[1][1] = map[1][1];
				dp[2][1] = map[2][1];

				for (int x = 2; x <= N; x++) {
					dp[1][x] = Math.max(dp[2][x - 1], dp[2][x - 2]) + map[1][x];
					dp[2][x] = Math.max(dp[1][x - 1], dp[1][x - 2]) + map[2][x];
				}

				int max = Math.max(dp[1][N], dp[2][N]);
				sb.append(max);
			}
			System.out.println(sb);
		}

		br.close();
	}
}

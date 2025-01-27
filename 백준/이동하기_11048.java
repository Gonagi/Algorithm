import java.io.*;
import java.util.*;

public class Main {
	static int[][] map, dp;
	static int N, M;
	static int[][] directions = { { 1, 0 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				for (int[] d : directions) {
					int nextY = y + d[0];
					int nextX = x + d[1];
					if (!canMove(nextY, nextX)) {
						continue;
					}
					if (d[0] == 1 && d[1] == 1) {
						dp[nextY][nextX] = Math.max(dp[y + 1][x], dp[y][x + 1]) + map[nextY][nextX];
					} else {
						dp[nextY][nextX] = Math.max(dp[nextY][nextX], dp[y][x] + map[nextY][nextX]);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[N][M]);
		System.out.println(dp[N][M]);
		br.close();
	}

	public static boolean canMove(int nextY, int nextX) {
		return nextY >= 1 && nextY <= N && nextX >= 1 && nextX <= M;
	}
}

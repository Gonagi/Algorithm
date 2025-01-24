import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, count;
	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		count = new int[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			String mapX = br.readLine();
			for (int x = 0; x < M; x++) {
				map[y][x + 1] = Character.getNumericValue(mapX.charAt(x));
			}
		}

		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { 1, 1 });
		count[1][1] = 1;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			if (cur[0] == N && cur[1] == M) {
				StringBuilder sb = new StringBuilder();
				System.out.println(sb.append(count[N][M]));
				br.close();
				return;
			}
			for (int[] dir : directions) {
				int nextY = cur[0] + dir[0];
				int nextX = cur[1] + dir[1];
				if (!canMove(nextY, nextX) || count[nextY][nextX] != 0 || map[nextY][nextX] == 0) {
					continue;
				}
				count[nextY][nextX] = count[cur[0]][cur[1]] + 1;
				que.add(new int[] { nextY, nextX });
			}
		}
	}

	public static boolean canMove(int y, int x) {
		return y >= 1 && y <= N && x >= 1 && x <= M;
	}
}

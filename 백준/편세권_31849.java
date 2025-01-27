import java.io.*;
import java.util.*;

public class Main {
	static int[][] map, distances;
	static int N, M, R, C, min = Integer.MAX_VALUE;
	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<int[]> houses = new ArrayList<>();
	static Queue<int[]> stores = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		input(br, st);
		bfs();
		calculate();

		System.out.println(min);
		br.close();
	}

	private static void calculate() {
		for (int[] house : houses) {
			int y = house[0];
			int x = house[1];
			int rent = map[y][x];
			if (distances[y][x] != Integer.MAX_VALUE) {
				min = Math.min(min, rent * distances[y][x]);
			}
		}
	}

	private static void input(BufferedReader br, StringTokenizer st) throws IOException {
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		distances = new int[N + 1][M + 1];

		for (int[] row : distances) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int rent = Integer.parseInt(st.nextToken());
			houses.add(new int[] { y, x });
			map[y][x] = rent;
		}

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			stores.add(new int[] { y, x });
			distances[y][x] = 0;
		}
	}

	private static void bfs() {
		while (!stores.isEmpty()) {
			int[] cur = stores.poll();
			int curY = cur[0];
			int curX = cur[1];

			for (int[] d : directions) {
				int nextY = curY + d[0];
				int nextX = curX + d[1];

				if (canMove(nextY, nextX) && distances[nextY][nextX] == Integer.MAX_VALUE) {
					distances[nextY][nextX] = distances[curY][curX] + 1;
					stores.add(new int[] { nextY, nextX });
				}
			}
		}
	}

	private static boolean canMove(int y, int x) {
		return y >= 1 && y <= N && x >= 1 && x <= M;
	}
}

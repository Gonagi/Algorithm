import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][N + 1];
		int[][] add = new int[N + 1][N + 1];

		List<Integer>[][] trees = new ArrayList[N + 1][N + 1];
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				trees[y][x] = new ArrayList<>();
			}
		}

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= N; x++) {
				map[y][x] = 5;
				add[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int idx = 0; idx < M; idx++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees[y][x].add(age);
		}

		for (int year = 1; year <= K; year++) {
			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					if (trees[y][x].isEmpty()) {
						continue;
					}
					Collections.sort(trees[y][x]);
					List<Integer> alive = new ArrayList<>();
					int deadNutrient = 0;

					for (int age : trees[y][x]) {
						if (map[y][x] >= age) {
							map[y][x] -= age;
							alive.add(age + 1);
						} else {
							deadNutrient += age / 2;
						}
					}

					trees[y][x] = alive;
					map[y][x] += deadNutrient;
				}
			}

			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					for (int age : trees[y][x]) {
						if (age % 5 == 0) {
							for (int[] d : directions) {
								int nextY = y + d[0];
								int nextX = x + d[1];
								if (!canMove(nextY, nextX)) {
									continue;
								}
								trees[nextY][nextX].add(1);
							}
						}
					}
				}
			}

			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					map[y][x] += add[y][x];
				}
			}
		}

		int result = 0;
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				result += trees[y][x].size();
			}
		}

		System.out.println(result);
		br.close();
	}

	private static boolean canMove(int y, int x) {
		return y >= 1 && y <= N && x >= 1 && x <= N;
	}
}

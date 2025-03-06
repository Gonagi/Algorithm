import java.io.*;
import java.util.*;

public class Solution {
	static int N, result;
	static int[][] map, directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] deleteCheeses;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			result = Integer.MIN_VALUE;
			int max = 0;
			for (int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
					max = max < map[y][x] ? map[y][x] : max;
				}
			}

			for (int cur = max; cur >= 0; cur--) {
				List<int[]> cheeses = new ArrayList<>();
				deleteCheeses = new boolean[N][N];
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						if (map[y][x] > cur) {
							cheeses.add(new int[] { y, x });
							continue;
						}
						deleteCheeses[y][x] = true;
					}
				}
				int count = 0;
				for (int[] cheese : cheeses) {
					int curY = cheese[0];
					int curX = cheese[1];
					if (deleteCheeses[curY][curX]) {
						continue;
					}
					BFS(curY, curX);
					count++;
				}
				if (result < count) {
					result = count;
				}
			}

			bw.write("#" + testCase + " " + result + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void BFS(int y, int x) {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { y, x });
		deleteCheeses[y][x] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int curY = cur[0];
			int curX = cur[1];
			for (int[] d : directions) {
				int nextY = curY + d[0];
				int nextX = curX + d[1];
				if (!canMove(nextY, nextX) || deleteCheeses[nextY][nextX]) {
					continue;
				}
				deleteCheeses[nextY][nextX] = true;
				que.add(new int[] { nextY, nextX });
			}
		}
	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}


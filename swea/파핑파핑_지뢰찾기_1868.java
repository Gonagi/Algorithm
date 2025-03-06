import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static List<int[]> zeros;
	static int[][] map,
			directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			zeros = new ArrayList<>();
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int y = 0; y < N; y++) {
				String inputX = br.readLine();
				for (int x = 0; x < N; x++) {
					if (inputX.charAt(x) == '*') {
						map[y][x] = -1;
					}
				}
			}

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] == -1) {
						continue;
					}
					int count = 0;
					for (int[] d : directions) {
						int nextY = y + d[0];
						int nextX = x + d[1];
						if (!canMove(nextY, nextX)) {
							continue;
						}
						if (map[nextY][nextX] == -1) {
							count++;
						}
					}
					if (count == 0) {
						zeros.add(new int[] { y, x });
					}
					map[y][x] = count;
				}
			}

			int curCount = 0;
			for (int[] zero : zeros) {
				Queue<int[]> que = new ArrayDeque<>();
				if (visited[zero[0]][zero[1]]) {
					continue;
				}
				visited[zero[0]][zero[1]] = true;
				que.add(zero);

				while (!que.isEmpty()) {
					int[] cur = que.poll();
					int curY = cur[0];
					int curX = cur[1];
					
					for (int[] d : directions) {
						int nearY = curY + d[0];
						int nearX = curX + d[1];
						if (!canMove(nearY, nearX) || visited[nearY][nearX] || map[nearY][nearX] == -1) {
							continue;
						}
						visited[nearY][nearX] = true;
						if (map[nearY][nearX] == 0) {
							que.add(new int[] { nearY, nearX });
						}
					}
				}
				curCount++;
			}

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (!visited[y][x] && map[y][x] != -1) {
						curCount++;
					}
				}
			}

			bw.write("#" + testCase + " " + curCount + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}


import java.io.*;
import java.util.*;

public class Main {
	static int Y, X;
	static int[][] map, directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];

		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0, result = 0;
		for (;; time++) {
			Queue<int[]> outside = new ArrayDeque<>();
			outside.add(new int[] { 0, 0 });
			boolean[][] checks = new boolean[Y][X];
			checks[0][0] = true;

			while (!outside.isEmpty()) {
				int[] cur = outside.poll();
				int curY = cur[0];
				int curX = cur[1];
				for (int[] d : directions) {
					int nextY = curY + d[0];
					int nextX = curX + d[1];
					if (!canMove(nextY, nextX) || map[nextY][nextX] == 1 || checks[nextY][nextX]) {
						continue;
					}
					checks[nextY][nextX] = true;
					outside.add(new int[] { nextY, nextX });
				}
			}
			
			Queue<int[]> que = new ArrayDeque<>();
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					if (map[y][x] == 1) {
						boolean check = false;
						for (int[] d : directions) {
							int nearY = y + d[0];
							int nearX = x + d[1];
							if (!canMove(nearY, nearX) || !checks[nearY][nearX]) {
								continue;
							}
							if (map[nearY][nearX] == 0) {
								check = true;
								break;
							}
						}
						if (check) {
							que.add(new int[] { y, x });
						}
					}
				}
			}
			if (que.isEmpty()) {
				break;
			}
			result = que.size();

			while (!que.isEmpty()) {
				int[] cur = que.poll();
				int curY = cur[0];
				int curX = cur[1];
				map[curY][curX] = 0;
			}

		}
		bw.write(time + "\n" + result);
		bw.flush();
		br.close();
		bw.close();

	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < Y && x >= 0 && x < X;
	}
}


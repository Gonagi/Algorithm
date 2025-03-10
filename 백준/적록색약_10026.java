import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<int[]> que;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];

		for (int y = 0; y < N; y++) {
			String mapX = br.readLine();
			for (int x = 0; x < N; x++) {
				map[y][x] = mapX.charAt(x);
			}
		}

		que = new ArrayDeque<>();
		int count = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (!visited[y][x]) {
					bfs(y, x);
					count++;
				}
			}
		}
		bw.write(count + " ");
		
		visited = new boolean[N][N];
		count = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == 'R') {
					map[y][x] = 'G';
				}
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (!visited[y][x]) {
					bfs(y, x);
					count++;
				}
			}
		}
		bw.write(count + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	static void bfs(int y, int x) {
		char curColor = map[y][x];
		que.add(new int[] { y, x });
		visited[y][x] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int curY = cur[0];
			int curX = cur[1];

			for (int[] d : directions) {
				int nextY = curY + d[0];
				int nextX = curX + d[1];
				if (!canMove(nextY, nextX) || visited[nextY][nextX] || map[nextY][nextX] != curColor) {
					continue;
				}
				visited[nextY][nextX] = true;
				que.add(new int[] { nextY, nextX });
			}
		}
	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}


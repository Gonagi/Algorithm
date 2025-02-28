import java.io.*;
import java.util.*;

public class Main {
	static int R, C, result;
	static char[][] map;
	static int[][] directions = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static boolean[][] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int y = 0; y < R; y++) {
			String mapX = br.readLine();
			for (int x = 0; x < C; x++) {
				map[y][x] = mapX.charAt(x);
			}
		}

		result = 0;
		for (int y = 0; y < R; y++) {
			dfs(y, 0);
		}

		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	static boolean dfs(int y, int x) {
		if (x == C - 1) {
			result++;
			return true;
		}

		for (int[] d : directions) {
			int nextY = y + d[0];
			int nextX = x + d[1];
			if (!canMove(nextY, nextX) || map[nextY][nextX] == 'x' || visited[nextY][nextX]) {
				continue;
			}
			visited[nextY][nextX] = true;
			if (dfs(nextY, nextX)) {
				return true;
			}
		}
		return false;
	}

	static boolean canMove(int y, int x) {
		return 0 <= y && y < R && 0 <= x && x < C;
	}
}


import java.io.*;
import java.util.*;

public class Main {
	static int R, C, max = 1;
	static char[][] board;
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];

		for (int y = 0; y < R; y++) {
			String inputX = br.readLine();
			for (int x = 0; x < C; x++) {
				board[y][x] = inputX.charAt(x);
			}
		}
		br.close();

		dfs(0, 0, 1, 1 << (board[0][0] - 'A'));
		StringBuilder sb = new StringBuilder();
		sb.append(max);
		System.out.println(sb);
	}

	static void dfs(int y, int x, int count, int visited) {
		max = Math.max(max, count);
		for (int[] d : directions) {
			int nextY = y + d[0];
			int nextX = x + d[1];
			if (!canMove(nextY, nextX)) {
				continue;
			}
            int letter = board[nextY][nextX] - 'A';
			if ((visited & (1 << letter)) == 0) {
				dfs(nextY, nextX, count + 1, visited | (1 << letter));
			}
		}
	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < R && x >= 0 && x < C;
	}
}


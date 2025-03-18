import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int y, x, count, d;

		public Node(int y, int x, int count, int d) {
			this.y = y;
			this.x = x;
			this.count = count;
			this.d = d;
		}
	}

	static int N, startY, startX, startD, endY, endX, endD;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N][2];

		for (int y = 0; y < N; y++) {
			String mapX = br.readLine();
			for (int x = 0; x < N; x++) {
				map[y][x] = mapX.charAt(x);
			}
		}

		findStart();
		findEnd();

		int result = 0;
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(startY, startX, result, startD));
		visited[startY][startX][startD] = true;
		while (!que.isEmpty()) {
			Node cur = que.poll();
			int curY = cur.y;
			int curX = cur.x;
			int curCount = cur.count;
			int curD = cur.d;

			if (curY == endY && curX == endX && curD == endD) {
				result = curCount;
				break;
			}

			int nextY = curY - 1;
			int nextX = curX;
			int nextD = curD;
			if (canMove(nextY, nextX, nextD) && !visited[nextY][nextX][nextD]) {
				visited[nextY][nextX][nextD] = true;
				que.add(new Node(nextY, nextX, curCount + 1, nextD));
			}
			nextY = curY + 1;
			nextX = curX;
			nextD = curD;
			if (canMove(nextY, nextX, nextD) && !visited[nextY][nextX][nextD]) {
				visited[nextY][nextX][nextD] = true;
				que.add(new Node(nextY, nextX, curCount + 1, nextD));
			}
			nextY = curY;
			nextX = curX - 1;
			nextD = curD;
			if (canMove(nextY, nextX, nextD) && !visited[nextY][nextX][nextD]) {
				visited[nextY][nextX][nextD] = true;
				que.add(new Node(nextY, nextX, curCount + 1, nextD));
			}
			nextY = curY;
			nextX = curX + 1;
			nextD = curD;
			if (canMove(nextY, nextX, nextD) && !visited[nextY][nextX][nextD]) {
				visited[nextY][nextX][nextD] = true;
				que.add(new Node(nextY, nextX, curCount + 1, nextD));
			}

			nextY = curY;
			nextX = curX;
			nextD = curD == 0 ? 1 : 0;
			if (canMove(nextY, nextX, nextD) && checkAdditional(nextY, nextX) && !visited[nextY][nextX][nextD]) {
				visited[nextY][nextX][nextD] = true;
				que.add(new Node(nextY, nextX, curCount + 1, nextD));
			}
		}
		bw.write(result + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static void findStart() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (check(y, x, 'B', 0)) {
					startY = y;
					startX = x;
					startD = 0;
					return;
				}
			}
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (check(y, x, 'B', 1)) {
					startY = y;
					startX = x;
					startD = 1;
					return;
				}
			}
		}
	}

	private static void findEnd() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (check(y, x, 'E', 0)) {
					endY = y;
					endX = x;
					endD = 0;
					return;
				}
			}
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (check(y, x, 'E', 1)) {
					endY = y;
					endX = x;
					endD = 1;
					return;
				}
			}
		}
	}

	static boolean check(int y, int x, char c, int d) {
		if (d == 0) {
			return y - 1 >= 0 && y + 1 < N && x >= 0 && x < N && map[y - 1][x] == c && map[y][x] == c
					&& map[y + 1][x] == c;
		} else {
			return y >= 0 && y < N && x - 1 >= 0 && x + 1 < N && map[y][x - 1] == c && map[y][x] == c
					&& map[y][x + 1] == c;
		}
	}

	static boolean canMove(int y, int x, int d) {
		if (d == 0) {
			return y - 1 >= 0 && y + 1 < N && x >= 0 && x < N && map[y - 1][x] != '1' && map[y][x] != '1'
					&& map[y + 1][x] != '1';
		} else {
			return y >= 0 && y < N && x - 1 >= 0 && x + 1 < N && map[y][x - 1] != '1' && map[y][x] != '1'
					&& map[y][x + 1] != '1';
		}
	}

	static boolean checkAdditional(int y, int x) {
		if (!(y - 1 >= 0 && y + 1 < N && x - 1 >= 0 && x + 1 < N)) {
			return false;
		}
		for (int r = y - 1; r <= y + 1; r++) {
			for (int c = x - 1; c <= x + 1; c++) {
				if (map[r][c] == '1') {
					return false;
				}
			}
		}
		return true;
	}
}


import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[][] map = new int[9][9];
	static List<Node> list = new ArrayList<>();
	static boolean[][] row = new boolean[9][10];
	static boolean[][] col = new boolean[9][10];
	static boolean[][] square = new boolean[9][10];

	static int size;
	static boolean isDone;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int y = 0; y < 9; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int x = 0; x < 9; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 0) {
					list.add(new Node(y, x));
				} else {
					int num = map[y][x];
					int box = getBox(y, x);

					row[y][num] = true;
					col[x][num] = true;
					square[box][num] = true;
				}
			}
		}

		size = list.size();
		dfs(0);
	}

	private static void dfs(int cur) {
		if (isDone) {
			return;
		}

		if (cur == size) {
			print();
			isDone = true;
			return;
		}

		Node curNode = list.get(cur);
		int y = curNode.y;
		int x = curNode.x;
		int box = getBox(y, x);

		for (int num = 1; num <= 9; num++) {
			if (!row[y][num] && !col[x][num] && !square[box][num]) {
				map[y][x] = num;
				row[y][num] = true;
				col[x][num] = true;
				square[box][num] = true;

				dfs(cur + 1);

				if (isDone) {
					return;
				}

				map[y][x] = 0;
				row[y][num] = false;
				col[x][num] = false;
				square[box][num] = false;
			}
		}
	}

	private static int getBox(int y, int x) {
		return (y / 3) * 3 + (x / 3);
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				sb.append(map[y][x]).append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}
}


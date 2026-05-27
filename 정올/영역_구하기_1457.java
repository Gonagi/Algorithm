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

	static int M, N, K;
	static boolean[][] map;
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[M][N];

		for (int idx = 0; idx < K; idx++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = true;
				}
			}
		}

		List<Integer> result = new ArrayList<>();

		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (!map[y][x]) {
					int size = bfs(y, x);
					result.add(size);
				}
			}
		}

		Collections.sort(result);

		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append('\n');
		for (int num : result) {
			sb.append(num).append(' ');
		}

		System.out.println(sb);
		br.close();
	}

	private static int bfs(int startY, int startX) {
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(startY, startX));
		map[startY][startX] = true;
		int size = 1;

		while (!que.isEmpty()) {
			Node curNode = que.poll();
			for (int[] dir : directions) {
				int nextY = curNode.y + dir[0];
				int nextX = curNode.x + dir[1];
				if (canMove(nextY, nextX) && !map[nextY][nextX]) {
					map[nextY][nextX] = true;
					que.add(new Node(nextY, nextX));
					size++;
				}
			}
		}

		return size;
	}

	private static boolean canMove(int y, int x) {
		return y >= 0 && y < M && x >= 0 && x < N;
	}
}


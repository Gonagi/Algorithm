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

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		Queue<Node> jaewooQue = new ArrayDeque<>();
		Queue<Node> fireQue = new ArrayDeque<>();

		for (int y = 0; y < R; y++) {
			String line = br.readLine();

			for (int x = 0; x < C; x++) {
				map[y][x] = line.charAt(x);

				if (map[y][x] == 'S') {
					jaewooQue.add(new Node(y, x));
					visited[y][x] = true;
				} else if (map[y][x] == '*') {
					fireQue.add(new Node(y, x));
				}
			}
		}

		int time = 0;

		while (!jaewooQue.isEmpty()) {
			int size = jaewooQue.size();
			for (int s = 0; s < size; s++) {
				Node cur = jaewooQue.poll();

				if (map[cur.y][cur.x] == '*') {
					continue;
				}

				for (int[] dir : directions) {
					int ny = cur.y + dir[0];
					int nx = cur.x + dir[1];

					if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || map[ny][nx] == 'X'
							|| map[ny][nx] == '*') {
						continue;
					}

					if (map[ny][nx] == 'D') {
						System.out.println(time + 1);
						return;
					}

					visited[ny][nx] = true;
					jaewooQue.add(new Node(ny, nx));
				}
			}

			size = fireQue.size();
			for (int i = 0; i < size; i++) {
				Node cur = fireQue.poll();

				for (int[] dir : directions) {
					int ny = cur.y + dir[0];
					int nx = cur.x + dir[1];

					if (ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == 'X' || map[ny][nx] == 'D'
							|| map[ny][nx] == '*') {
						continue;
					}

					map[ny][nx] = '*';
					fireQue.add(new Node(ny, nx));
				}
			}

			time++;
		}

		System.out.println("impossible");
		br.close();
	}
}


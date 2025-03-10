import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D, result = 0;
	static boolean[][] map, map2;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		map2 = new boolean[N][M];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = st.nextToken().equals("1") ? true : false;
				map2[y][x] = map[y][x];
			}
		}

		visited = new boolean[M];
		dfs(0, 0);
		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int start, int count) {
		if (count == 3) {
			List<Integer> list = new ArrayList<>();
			for (int idx = 0; idx < M; idx++) {
				if (visited[idx]) {
					list.add(idx);
				}
			}
			for (int y = 0; y < N; y++) {
				map[y] = map2[y].clone();
			}

			result = Math.max(result, simulate(list));
			return;
		}
		for (int idx = start; idx < M; idx++) {
			if (visited[idx]) {
				continue;
			}
			visited[idx] = true;
			dfs(idx + 1, count + 1);
			visited[idx] = false;
		}
	}

	static int simulate(List<Integer> list) {
		int count = 0;
		for (int turn = 0; turn < N; turn++) {
			if (isDone()) {
				return count;
			}
			boolean[][] targets = new boolean[N][M];
			for (int archer : list) {
				int targetRow = -1, targetCol = -1;
				int minDist = Integer.MAX_VALUE;

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (!map[r][c]) {
							continue;
						}
						int dist = Math.abs(N - r) + Math.abs(archer - c);
						if (dist <= D) {
							if (dist < minDist) {
								minDist = dist;
								targetRow = r;
								targetCol = c;
							} else if (dist == minDist && c < targetCol) {
								targetRow = r;
								targetCol = c;
							}
						}
					}
				}
				if (targetRow != -1) {
					targets[targetRow][targetCol] = true;
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (targets[r][c] && map[r][c]) {
						map[r][c] = false;
						count++;
					}
				}
			}
			for (int r = N - 1; r >= 0; r--) {
				for (int c = 0; c < M; c++) {
					if (r == 0)
						map[r][c] = false;
					else
						map[r][c] = map[r - 1][c];
				}
			}

		}
		return count;
	}

	static boolean isDone() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x])
					return false;
			}
		}
		return true;
	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}


import java.io.*;
import java.util.*;

class Main {
	static int N, M, result;
	static List<CCTV> cctvs;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		cctvs = new ArrayList<>();
		int[][] map = new int[N][M];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (1 <= map[y][x] && map[y][x] <= 5) {
					cctvs.add(new CCTV(y, x, map[y][x]));
				}
			}
		}
		DFS(0, map);
		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	private static void DFS(int count, int[][] curMap) {
		if (count == cctvs.size()) {
			int c = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (curMap[y][x] == 0) {
						c++;
					}
				}
			}
			result = Math.min(result, c);
			return;
		}

		int curY = cctvs.get(count).y;
		int curX = cctvs.get(count).x;
		int curNumber = cctvs.get(count).number;
		List<int[]> nextMap;
		if (curNumber == 1) {

			nextMap = new ArrayList<>();
			checkLeft(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkRight(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkUp(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkDown(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);
		} else if (curNumber == 2) {
			nextMap = new ArrayList<>();
			checkLeft(curY, curX, curMap, nextMap);
			checkRight(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkUp(curY, curX, curMap, nextMap);
			checkDown(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);
		} else if (curNumber == 3) {
			nextMap = new ArrayList<>();
			checkUp(curY, curX, curMap, nextMap);
			checkRight(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkRight(curY, curX, curMap, nextMap);
			checkDown(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkLeft(curY, curX, curMap, nextMap);
			checkDown(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkUp(curY, curX, curMap, nextMap);
			checkLeft(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);
		} else if (curNumber == 4) {
			nextMap = new ArrayList<>();
			checkLeft(curY, curX, curMap, nextMap);
			checkUp(curY, curX, curMap, nextMap);
			checkRight(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkUp(curY, curX, curMap, nextMap);
			checkRight(curY, curX, curMap, nextMap);
			checkDown(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkLeft(curY, curX, curMap, nextMap);
			checkDown(curY, curX, curMap, nextMap);
			checkRight(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);

			nextMap = new ArrayList<>();
			checkUp(curY, curX, curMap, nextMap);
			checkLeft(curY, curX, curMap, nextMap);
			checkDown(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);
		} else if (curNumber == 5) {
			nextMap = new ArrayList<>();
			checkLeft(curY, curX, curMap, nextMap);
			checkRight(curY, curX, curMap, nextMap);
			checkUp(curY, curX, curMap, nextMap);
			checkDown(curY, curX, curMap, nextMap);
			DFS(count + 1, curMap);
			undo(curMap, nextMap);
		}
	}

	private static void undo(int[][] curMap, List<int[]> nextMap) {
		for (int[] mapX : nextMap) {
			curMap[mapX[0]][mapX[1]] = 0;
		}
	}

	private static void checkLeft(int curY, int curX, int[][] curMap, List<int[]> nextMap) {
		for (int x = curX - 1; x >= 0; x--) {
			if (curMap[curY][x] == 6) {
				return;
			}
			if (curMap[curY][x] != 0) {
				continue;
			}
			curMap[curY][x] = -1;
			nextMap.add(new int[] { curY, x });
		}
	}

	private static void checkRight(int curY, int curX, int[][] curMap, List<int[]> nextMap) {
		for (int x = curX + 1; x < M; x++) {
			if (curMap[curY][x] == 6) {
				return;
			}
			if (curMap[curY][x] != 0) {
				continue;
			}
			curMap[curY][x] = -1;
			nextMap.add(new int[] { curY, x });
		}
	}

	private static void checkUp(int curY, int curX, int[][] curMap, List<int[]> nextMap) {
		for (int y = curY - 1; y >= 0; y--) {
			if (curMap[y][curX] == 6) {
				return;
			}
			if (curMap[y][curX] != 0) {
				continue;
			}
			curMap[y][curX] = -1;
			nextMap.add(new int[] { y, curX });
		}
	}

	private static void checkDown(int curY, int curX, int[][] curMap, List<int[]> nextMap) {
		for (int y = curY + 1; y < N; y++) {
			if (curMap[y][curX] == 6) {
				return;
			}
			if (curMap[y][curX] != 0) {
				continue;
			}
			curMap[y][curX] = -1;
			nextMap.add(new int[] { y, curX });
		}
	}

	static class CCTV {
		int y, x, number;

		public CCTV(int y, int x, int number) {
			this.y = y;
			this.x = x;
			this.number = number;
		}
	}
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String input = st.nextToken();
			map = new int[N][N];
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			if (input.equals("left")) {
				for (int y = 0; y < N; y++) {
					slideXDirection(y, true);
					sumXDirection(y, true);
					slideXDirection(y, true);
				}
			} else if (input.equals("right")) {
				for (int y = N - 1; y >= 0; y--) {
					slideXDirection(y, false);
					sumXDirection(y, false);
					slideXDirection(y, false);
				}
			} else if (input.equals("up")) {
				for (int x = 0; x < N; x++) {
					slideYDirection(x, true);
					sumYDirection(x, true);
					slideYDirection(x, true);
				}
			} else if (input.equals("down")) {
				for (int x = 0; x < N; x++) {
					slideYDirection(x, false);
					sumYDirection(x, false);
					slideYDirection(x, false);
				}
			}
			bw.write("#" + testCase + "\n");
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					bw.write(map[y][x] + " ");
				}
				bw.newLine();
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static void slideYDirection(int x, boolean d) {
		if (d) {
			for (int y = 0; y < N - 1; y++) {
				if (map[y][x] != 0) {
					continue;
				}
				for (int idx = y + 1; idx < N; idx++) {
					if (map[idx][x] != 0) {
						map[y][x] = map[idx][x];
						map[idx][x] = 0;
						break;
					}
				}
			}
		} else {
			for (int y = N - 1; y >= 1; y--) {
				if (map[y][x] != 0) {
					continue;
				}
				for (int idx = y - 1; idx >= 0; idx--) {
					if (map[idx][x] != 0) {
						map[y][x] = map[idx][x];
						map[idx][x] = 0;
						break;
					}
				}
			}
		}
	}

	private static void slideXDirection(int y, boolean d) {
		if (d) {
			for (int x = 0; x < N - 1; x++) {
				if (map[y][x] != 0) {
					continue;
				}
				for (int idx = x + 1; idx < N; idx++) {
					if (map[y][idx] != 0) {
						map[y][x] = map[y][idx];
						map[y][idx] = 0;
						break;
					}
				}
			}
		} else {
			for (int x = N - 1; x >= 1; x--) {
				if (map[y][x] != 0) {
					continue;
				}
				for (int idx = x - 1; idx >= 0; idx--) {
					if (map[y][idx] != 0) {
						map[y][x] = map[y][idx];
						map[y][idx] = 0;
						break;
					}
				}
			}
		}
	}

	private static void sumYDirection(int x, boolean d) {
		if (d) {
			for (int y = 0; y < N - 1; y++) {
				if (map[y][x] == 0) {
					continue;
				}
				if (map[y][x] == map[y + 1][x]) {
					map[y][x] *= 2;
					map[y + 1][x] = 0;
				}
			}
		} else {
			for (int y = N - 1; y >= 1; y--) {
				if (map[y][x] == 0) {
					continue;
				}
				if (map[y][x] == map[y - 1][x]) {
					map[y][x] *= 2;
					map[y - 1][x] = 0;
				}
			}
		}
	}

	private static void sumXDirection(int y, boolean d) {
		if (d) {
			for (int x = 0; x < N - 1; x++) {
				if (map[y][x] == 0) {
					continue;
				}
				if (map[y][x] == map[y][x + 1]) {
					map[y][x] *= 2;
					map[y][x + 1] = 0;
				}
			}
		} else {
			for (int x = N - 1; x >= 1; x--) {
				if (map[y][x] == 0) {
					continue;
				}
				if (map[y][x] == map[y][x - 1]) {
					map[y][x] *= 2;
					map[y][x - 1] = 0;
				}
			}
		}
	}
}


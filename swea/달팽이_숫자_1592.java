import java.io.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			int curY = 0, curX = 0;
			int dirIdx = 0;
			map[curY][curX] = 1;
			for (int num = 2; num <= N * N; num++) {
				int nextY = curY + directions[dirIdx][0];
				int nextX = curX + directions[dirIdx][1];

				if (!canMove(nextY, nextX) || map[nextY][nextX] != 0) {
					dirIdx = (dirIdx + 1) % 4;
					nextY = curY + directions[dirIdx][0];
					nextX = curX + directions[dirIdx][1];
				}
				map[nextY][nextX] = num;
				curY = nextY;
				curX = nextX;
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
		bw.close();
		br.close();

	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}


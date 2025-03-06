import java.io.*;
import java.util.*;

public class Solution {
	static int H, W, N;
	static char[][] map;
	static String inputs;
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			int curY = 0, curX = 0;
			int[] curDirection = new int[2];
			for (int y = 0; y < H; y++) {
				String inputX = br.readLine();
				for (int x = 0; x < W; x++) {
					map[y][x] = inputX.charAt(x);
					if (map[y][x] == '^' || map[y][x] == 'v' || map[y][x] == '<' || map[y][x] == '>') {
						curY = y;
						curX = x;
						if (map[y][x] == '^') {
							curDirection[0] = directions[0][0];
							curDirection[1] = directions[0][1];
						} else if (map[y][x] == 'v') {
							curDirection[0] = directions[1][0];
							curDirection[1] = directions[1][1];
						} else if (map[y][x] == '<') {
							curDirection[0] = directions[2][0];
							curDirection[1] = directions[2][1];
						} else if (map[y][x] == '>') {
							curDirection[0] = directions[3][0];
							curDirection[1] = directions[3][1];
						}
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			inputs = br.readLine();

			for (int idx = 0; idx < N; idx++) {
				if (inputs.charAt(idx) == 'U') {
					curDirection[0] = directions[0][0];
					curDirection[1] = directions[0][1];
					int nextY = curY + curDirection[0];
					int nextX = curX + curDirection[1];
					if (canMove(nextY, nextX) && map[nextY][nextX] == '.') {
						map[curY][curX] = '.';
						curY = nextY;
						curX = nextX;
					}
					map[curY][curX] = '^';

				} else if (inputs.charAt(idx) == 'D') {
					curDirection[0] = directions[1][0];
					curDirection[1] = directions[1][1];
					int nextY = curY + curDirection[0];
					int nextX = curX + curDirection[1];
					if (canMove(nextY, nextX) && map[nextY][nextX] == '.') {
						map[curY][curX] = '.';
						curY = nextY;
						curX = nextX;
					}
					map[curY][curX] = 'v';
				} else if (inputs.charAt(idx) == 'L') {
					curDirection[0] = directions[2][0];
					curDirection[1] = directions[2][1];
					int nextY = curY + curDirection[0];
					int nextX = curX + curDirection[1];
					if (canMove(nextY, nextX) && map[nextY][nextX] == '.') {
						map[curY][curX] = '.';
						curY = nextY;
						curX = nextX;
					}
					map[curY][curX] = '<';
				} else if (inputs.charAt(idx) == 'R') {
					curDirection[0] = directions[3][0];
					curDirection[1] = directions[3][1];
					int nextY = curY + curDirection[0];
					int nextX = curX + curDirection[1];
					if (canMove(nextY, nextX) && map[nextY][nextX] == '.') {
						map[curY][curX] = '.';
						curY = nextY;
						curX = nextX;
					}
					map[curY][curX] = '>';
				} else if (inputs.charAt(idx) == 'S') {
					int nextY = curY + curDirection[0];
					int nextX = curX + curDirection[1];
					while (true) {
						if (!canMove(nextY, nextX) || map[nextY][nextX] == '#') {
							break;
						} else if (map[nextY][nextX] == '*') {
							map[nextY][nextX] = '.';
							break;
						}
						nextY += curDirection[0];
						nextX += curDirection[1];
					}
				}
			}

			bw.write("#" + testCase + " ");
			for (int y = 0; y < H; y++) {
				for (int x = 0; x < W; x++) {
					bw.write(map[y][x]);
				}
				bw.newLine();
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < H && x >= 0 && x < W;
	}
}


import java.io.*;
import java.util.*;

public class Main {
	private final static int SIZE = 20;
	static final int[][] DIRECTIONS = { { 1, 1 }, { 0, 1 }, { -1, 1 }, { 1, 0 } };

	static int[][] map = new int[SIZE][SIZE];
	static List<int[]> blacks = new ArrayList<>();
	static List<int[]> whites = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);

		for (int[] d : DIRECTIONS) {
			for (int[] black : blacks) {
				int y = black[0];
				int x = black[1];
				for (int count = 0; count < 4; count++) {
					y += d[0];
					x += d[1];
					if (!canMove(y, x) || map[y][x] != 1) {
						break;
					}
					if (count == 3) {
						int prevY = black[0] + -1 * d[0];
						int prevX = black[1] + -1 * d[1];
						int nextY = y + d[0];
						int nextX = x + d[1];
						if ((!canMove(prevY, prevX) || map[prevY][prevX] != 1)
								&& (!canMove(nextY, nextX) || map[nextY][nextX] != 1)) {
							StringBuilder sb = new StringBuilder();
							sb.append(1).append("\n").append(black[0]).append(" ").append(black[1]);
							System.out.println(sb);
							return;
						}
					}
				}
			}
			for (int[] white : whites) {
				int y = white[0];
				int x = white[1];
				for (int count = 0; count < 4; count++) {
					y += d[0];
					x += d[1];
					if (!canMove(y, x) || map[y][x] != 2) {
						break;
					}
					if (count == 3) {
						int prevY = white[0] + -1 * d[0];
						int prevX = white[1] + -1 * d[1];
						int nextY = y + d[0];
						int nextX = x + d[1];
						if ((!canMove(prevY, prevX) || map[prevY][prevX] != 2)
								&& (!canMove(nextY, nextX) || map[nextY][nextX] != 2)) {
							StringBuilder sb = new StringBuilder();
							sb.append(2).append("\n").append(white[0]).append(" ").append(white[1]);
							System.out.println(sb);
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
		br.close();
	}

	private static void input(BufferedReader br) throws IOException {
		for (int y = 1; y < SIZE; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 1; x < SIZE; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 1) {
					blacks.add(new int[] { y, x });
				} else if (map[y][x] == 2) {
					whites.add(new int[] { y, x });
				}
			}
		}
	}

	private static boolean canMove(int y, int x) {
		return 1 <= y && y < SIZE && 1 <= x && x < SIZE;
	}
}


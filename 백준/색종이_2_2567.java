import java.io.*;
import java.util.*;

public class Main {
	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		boolean[][] blackMap = new boolean[100][100];

		for (int idx = 0; idx < count; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					blackMap[y + r][x + c] = true;
				}
			}
		}

		int result = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				for (int[] d : directions) {
					if (!blackMap[r][c]) {
						continue;
					}
					int nextY = r + d[0];
					int nextX = c + d[1];
					if (!canMove(nextY, nextX) || !blackMap[nextY][nextX]) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
		br.close();
	}

	private static boolean canMove(int y, int x) {
		return y >= 0 && y < 100 && x >= 0 && x < 100;
	}
}

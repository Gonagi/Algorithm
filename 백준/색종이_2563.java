import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] map = new boolean[101][101];
		int count = Integer.parseInt(br.readLine());
		int result = 0;

		for (int idx = 0; idx < count; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int r = y; r < y + 10; r++) {
				for (int c = x; c < x + 10; c++) {
					if (!map[r][c]) {
						map[r][c] = true;
						result++;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(result);
		System.out.print(result);
		br.close();
		return;
	}
}

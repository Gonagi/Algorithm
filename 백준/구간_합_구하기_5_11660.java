import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, sum;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		sum = new int[N + 1][N + 1];

		for (int x = 1; x <= N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 1; y <= N; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
			}
		}

		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				sum[x][y] = sum[x - 1][y] + sum[x][y - 1] - sum[x - 1][y - 1] + map[x][y];
			}
		}

		int x1, x2, y1, y2;
		for (int idx = 1; idx <= M; idx++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			bw.write(sum[x2][y2] - (sum[x2][y1 - 1] + sum[x1 - 1][y2] - sum[x1 - 1][y1 - 1]) + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}


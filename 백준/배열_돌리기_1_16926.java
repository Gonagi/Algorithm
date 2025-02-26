import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
	static int[][] map;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int count = Math.min(N, M) / 2;
		for (int idx = 0; idx < R; idx++) {
			for (int idx2 = 0; idx2 < count; idx2++) {
				int temp = map[idx2][idx2];

				for (int idx3 = idx2 + 1; idx3 < M - idx2; idx3++)
					map[idx2][idx3 - 1] = map[idx2][idx3];

				for (int idx3 = idx2 + 1; idx3 < N - idx2; idx3++)
					map[idx3 - 1][M - 1 - idx2] = map[idx3][M - 1 - idx2];

				for (int idx3 = M - 2 - idx2; idx3 >= idx2; idx3--)
					map[N - 1 - idx2][idx3 + 1] = map[N - 1 - idx2][idx3];

				for (int idx3 = N - 2 - idx2; idx3 >= idx2; idx3--)
					map[idx3 + 1][idx2] = map[idx3][idx2];

				map[idx2 + 1][idx2] = temp;
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				bw.write(map[y][x] + " ");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}


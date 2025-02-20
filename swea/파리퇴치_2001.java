import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, result;
	static int[][] map, sum;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 1][N + 1];
			sum = new int[N + 1][N + 1];
			result = 0;

			for (int y = 1; y <= N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 1; x <= N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
					sum[y][x] = sum[y][x - 1] + sum[y - 1][x] - sum[y - 1][x - 1] + map[y][x];
				}
			}

			for (int y = M; y <= N; y++) {
				for (int x = M; x <= N; x++) {
					result = Math.max(result, sum[y][x] - sum[y][x - M] - sum[y - M][x] + sum[y - M][x - M]);
				}
			}
			bw.write("#" + testCase + " " + result + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}


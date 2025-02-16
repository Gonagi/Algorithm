package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] map = new int[1001][1001];
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N + 1];
		int minX = 1001, minY = 1001, maxX = 0, maxY = 0;

		for (int idx = 1; idx <= N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			minX = Math.min(minX, x);
			minY = Math.min(minY, y);
			maxX = Math.max(maxX, x + w);
			maxY = Math.max(maxY, y + h);

			for (int c = x; c < x + w; c++) {
				for (int r = y; r < y + h; r++) {
					map[r][c] = idx;
				}
			}
		}

		for (int y = minY; y < maxY; y++) {
			for (int x = minX; x < maxX; x++) {
				count[map[y][x]]++;
			}
		}

		for (int idx = 1; idx <= N; idx++) {
			bw.write(count[idx] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}

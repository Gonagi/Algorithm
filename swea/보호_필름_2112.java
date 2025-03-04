import java.io.*;
import java.util.*;

public class Solution {
	static int D, W, K, result;
	static char[][] map;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			map = new char[D][W];

			for (int y = 0; y < D; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < W; x++) {
					if (st.nextToken().equals("0")) {
						map[y][x] = 'A';
					} else {
						map[y][x] = 'B';
					}
				}
			}

			if (checks()) {
				bw.write("#" + testCase + " " + 0 + "\n");
			} else {
				dfs(0, 0);
				bw.write("#" + testCase + " " + result + "\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static boolean checks() {
		for (int x = 0; x < W; x++) {
			if (!check(x)) {
				return false;
			}
		}
		return true;
	}

	static boolean check(int x) {
		int count = 0;
		for (int y = 0; y < D - 1; y++) {
			if (map[y][x] == map[y + 1][x]) {
				count++;
			} else {
				count = 0;
			}
			if (count == K - 1) {
				return true;
			}
		}
		return false;
	}

	static void dfs(int y, int count) {
		if(count >= result) {
			return;
		}
		if (checks()) {
			result = Math.min(result, count);
			return;
		}
		if (y == D) {
			return;
		}

		dfs(y + 1, count);
		char[] temp = map[y].clone();
		Arrays.fill(map[y], 'A');
		dfs(y + 1, count + 1);
		map[y] = temp.clone();
		
		Arrays.fill(map[y], 'B');
		dfs(y + 1, count + 1);
		map[y] = temp;
	}
}


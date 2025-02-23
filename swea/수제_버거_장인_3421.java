import java.io.*;
import java.util.*;

public class Solution {
	static boolean[] selected;
	static boolean[][] prohibits;
	static int result, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			selected = new boolean[N + 1];
			prohibits = new boolean[N + 1][N + 1];

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				prohibits[from][to]= true;
				prohibits[to][from]= true;
			}

			result = 0;
			backtrack(1);
			bw.write("#" + testCase + " " + result + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static void backtrack(int curNum) {
		if (curNum > N) {
			result++;
			return;
		}
		
		backtrack(curNum + 1);

		for (int num = 1; num < curNum; num++) {
			if (selected[num] && prohibits[num][curNum]) {
				return;
			}
		}
		selected[curNum] = true;
		backtrack(curNum + 1);
		selected[curNum] = false;
	}
}


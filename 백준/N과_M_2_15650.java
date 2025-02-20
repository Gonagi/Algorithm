import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] numbers, result;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			numbers[idx] = idx;
		}
		result = new int[M + 1];

		solve(0, 1);

		br.close();
	}

	static void solve(int cnt, int start) {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int idx = 0; idx < M; idx++) {
				sb.append(result[idx]).append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int idx = start; idx <= N; idx++) {
			result[cnt] = numbers[idx];
			solve(cnt + 1, idx + 1);
		}
	}
}


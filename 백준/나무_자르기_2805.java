import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static long[] trees;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < N; idx++) {
			trees[idx] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(trees);
		long left = 0;
		long right = trees[N - 1];

		while (left <= right) {
			long mid = left + (right - left) / 2;
			long count = 0;
			for (int idx = N - 1; idx >= 0; idx--) {
				if (trees[idx] <= mid) {
					break;
				}
				count += (trees[idx] - mid);
			}
			if (count >= M) {
				left = mid + 1;
			} else if (count < M) {
				right = mid - 1;
			}
		}

		bw.write(right + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}


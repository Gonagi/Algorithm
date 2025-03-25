import java.io.*;
import java.util.*;

class Main {
	static int K, N;
	static long[] lans;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lans = new long[K];
		for (int idx = 0; idx < K; idx++) {
			lans[idx] = Long.parseLong(br.readLine());
		}

		Arrays.sort(lans);

		long left = 0;
		long right = lans[K - 1];

		while (left <= right) {
			long mid = left + (right - left) / 2;
			if (mid == 0) {
				break;
			}
			long count = 0;
			for (int idx = 0; idx < K; idx++) {
				count += (lans[idx] / mid);
			}

			if (count < N) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		bw.write(right + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}


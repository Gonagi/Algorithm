import java.io.*;
import java.util.*;

public class Main {
	static long L;
	static int N, K;
	static long[] lights;
	static long[] diff;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Long.parseLong(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		lights = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < N; idx++) {
			lights[idx] = Long.parseLong(st.nextToken());
		}

		diff = new long[K + 2];

		addRange(1, Math.min(lights[0], K), 1);
		addRange(1, Math.min(L - lights[N - 1], K), 1);

		for (int idx = 0; idx < N - 1; idx++) {
			long gap = lights[idx + 1] - lights[idx];

			long twoEnd = (gap - 1) / 2;
			addRange(1, Math.min(twoEnd, K), 2);

			if (gap % 2 == 0) {
				long mid = gap / 2;

				if (mid <= K) {
					addRange(mid, mid, 1);
				}
			}
		}

		int count = 0;

		for (int idx = 0; idx < N && count < K; idx++) {
			sb.append(0).append('\n');
			count++;
		}

		long curCount = 0;

		for (int distance = 1; distance <= K && count < K; distance++) {
			curCount += diff[distance];

			long sameDistanceCount = curCount;

			while (sameDistanceCount > 0 && count < K) {
				sb.append(distance).append('\n');
				sameDistanceCount--;
				count++;
			}
		}

		System.out.print(sb);
		br.close();
	}

	private static void addRange(long left, long right, long value) {
		if (left > right) {
			return;
		}

		int l = (int) left;
		int r = (int) right;

		diff[l] += value;
		diff[r + 1] -= value;
	}
}


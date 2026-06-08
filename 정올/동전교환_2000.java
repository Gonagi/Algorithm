import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] coin = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < N; idx++) {
			coin[idx] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(coin);

		int W = Integer.parseInt(br.readLine());
		int[] dp = new int[W + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int value = 1; value <= W; value++) {
			for (int cur : coin) {
				if (value - cur < 0) {
					break;
				}

				if (dp[value - cur] != Integer.MAX_VALUE) {
					dp[value] = Math.min(dp[value], dp[value - cur] + 1);
				}
			}
		}

		System.out.println(dp[W] == Integer.MAX_VALUE ? "impossible" : dp[W]);
		br.close();
	}
}


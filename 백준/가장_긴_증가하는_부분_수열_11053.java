import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[1001];
		int[] dp = new int[1001];
		Arrays.fill(dp, 1);
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 1; idx <= N; idx++) {
			A[idx] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (A[i] > A[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}

		int max = 0;
		for (int value : dp) {
			max = Math.max(value, max);
		}

		System.out.println(max);
		br.close();
	}
}

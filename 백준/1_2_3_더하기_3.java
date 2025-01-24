import java.io.*;

public class Main {
	static int[] dp = new int[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int num = 4; num <= 1000000; num++) {
			dp[num] = (int) (((long) dp[num - 1] + (long) dp[num - 2] + (long) dp[num - 3]) % 1000000009);
		}

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append(dp[N]));
		}
		br.close();
	}
}

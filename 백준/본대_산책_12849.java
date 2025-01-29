import java.io.*;

public class Main {
	static final long DIV = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][8];
		dp[0][0] = 1;
		
		for (int d = 0; d < D; d++) {
			dp[d + 1][0] = (dp[d][1] + dp[d][2]) % DIV;
			dp[d + 1][1] = (dp[d][0] + dp[d][2] + dp[d][3]) % DIV;
			dp[d + 1][2] = (dp[d][0] + dp[d][1] + dp[d][3] + dp[d][4]) % DIV;
			dp[d + 1][3] = (dp[d][1] + dp[d][2] + dp[d][4] + dp[d][5]) % DIV;
			dp[d + 1][4] = (dp[d][2] + dp[d][3] + dp[d][5] + dp[d][6]) % DIV;
			dp[d + 1][5] = (dp[d][3] + dp[d][4] + dp[d][7]) % DIV;
			dp[d + 1][6] = (dp[d][4] + dp[d][7]) % DIV;
			dp[d + 1][7] = (dp[d][5] + dp[d][6]) % DIV;
		}

		System.out.println(dp[D][0]);
		br.close();
	}
}

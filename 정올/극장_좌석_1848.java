import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int idx = 3; idx <= 40; idx++) {
			dp[idx] = dp[idx - 1] + dp[idx - 2];
		}

		int start = 0, result = 1;
		for (int idx = 0; idx < M; idx++) {
			int num = Integer.parseInt(br.readLine());
			result *= dp[num - start - 1];
			start = num;
		}

		result *= dp[N - start];

		System.out.println(result);
		br.close();
	}
}


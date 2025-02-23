import java.io.*;

public class Main {
	static int N;
	static BufferedWriter bw;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		br.close();

		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);

		bw.flush();
		bw.close();
	}

	private static void dfs(int num, int cnt) throws Exception {
		if (cnt == N) {
			bw.write(num + "\n");
			return;
		}

		int[] candidates = { 1, 3, 7, 9 };
		for (int d : candidates) {
			int newNum = num * 10 + d;
			if (isPrime(newNum)) {
				dfs(newNum, cnt + 1);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int n = 2; n * n < num; n++) {
			if (num % n == 0) {
				return false;
			}
		}
		return true;
	}
}


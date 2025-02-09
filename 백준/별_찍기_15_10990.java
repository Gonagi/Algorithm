import java.io.*;

class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if (N == 1) {
			sb.append("*");
		} else {
			print(N);
		}
		System.out.println(sb);
		br.close();
	}

	private static void print(int n) {
		if (n == 0) {
			return;
		}
		print(n - 1);

		if (n == 1) {
			for (int idx = 0; idx < N - 1; idx++) {
				sb.append(" ");
			}
			sb.append("*\n");
			print(n - 1);
		} else {
			for(int idx = 0; idx < N - n; idx++) {
				sb.append(" ");
			}
			sb.append("*");
			
			for (int idx = 0; idx < 1 + 2 * (n - 2); idx++) {
				sb.append(" ");
			}

			sb.append("*\n");
		}
	}
}

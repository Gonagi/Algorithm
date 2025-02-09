import java.io.*;

class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		print(N);
		System.out.println(sb);
		br.close();
	}

	private static void print(int n) {
		if (n == 0) {
			return;
		}
		print(n - 1);
		for (int idx = 0; idx < N - n; idx++) {
			sb.append(" ");
		}
		sb.append("*");
		
		if (n != 1) {
			for(int idx = 0; idx < (n-1) * 2; idx++) {
				if(idx % 2 == 0) {
					sb.append(" ");
				}else {
					sb.append("*");
				}
			}
		}
		sb.append("\n");
	}
}

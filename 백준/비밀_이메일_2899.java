import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = input.length();
		int R = 0, C = 0;
		for (int n = 1; n <= N / 2; n++) {
			if (N % n == 0) {
				if (n <= N / n) {
					R = n;
					C = N / n;
				}
			}
		}
		char[][] arr = new char[R][C];
		for (int x = 0; x < C; x++) {
			for (int y = 0; y < R; y++) {
				arr[y][x] = input.charAt(y + x * R);

			}
		}

		StringBuilder sb = new StringBuilder();
		for(int y = 0; y < R; y++) {
			for(int x = 0; x < C; x++) {
				sb.append(arr[y][x]);
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}

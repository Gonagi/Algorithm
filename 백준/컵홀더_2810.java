import java.io.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();

		int count = 0;
		for (int idx = 0; idx < N; idx++) {
			if (input.charAt(idx) == 'S') {
				count++;
			} else {
				idx++;
				count++;
			}
		}
		count++;
		StringBuilder sb = new StringBuilder();
		sb.append(count < N ? count : N);
		System.out.println(sb);
		br.close();
	}
}

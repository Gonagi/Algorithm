import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int expectedMax = 0, expectedIdx = 0, result = 0, sum  =0;
		int[] cake = new int[L + 1];
		for (int idx = 1; idx <= N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if (expectedMax < (K - P)) {
				expectedMax = (K - P);
				expectedIdx = idx;
			}
			
			int count = 0;
			for (int i = P; i <= K; i++) {
				if (cake[i] != 0) {
					continue;
				}
				cake[i] = idx;
				count++;
			}

			if (sum < count) {
				sum = count;
				result = idx;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(expectedIdx).append('\n').append(result);
		System.out.println(sb);

		br.close();
	}
}

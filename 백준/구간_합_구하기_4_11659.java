import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] numbers, sum;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N + 1];
		sum = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int idx = 1; idx <= N; idx++) {
			numbers[idx] = Integer.parseInt(st.nextToken());
			sum[idx] = sum[idx - 1] + numbers[idx];
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			bw.write(sum[end] - sum[start - 1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}


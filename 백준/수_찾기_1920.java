import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long M;
	static long[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		numbers = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < N; idx++) {
			numbers[idx] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(numbers);

		M = Long.parseLong(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < M; idx++) {
			long cur = Long.parseLong(st.nextToken());
			int left = 0;
			int right = N - 1;
			boolean check = false;
			while (left <= right) {
				int mid = (left + right) / 2;
				long midValue = numbers[mid];

				if (midValue == cur) {
					check = true;
					break;
				}
				if (midValue < cur) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			
			if (check) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}


import java.io.*;
import java.util.*;

public class Main {
	static int N, C;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		for (int idx = 0; idx < N; idx++) {
			numbers[idx] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(numbers);

		int left = 1;
		int right = numbers[N - 1] - numbers[0];
		int result = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int prev = numbers[0];
			int count = 1;

			for (int cur = 1; cur < N; cur++) {
				if (numbers[cur] - prev >= mid) {
					prev = numbers[cur];
					count++;
				}
			}

			if (count < C) {
				right = mid - 1;
			} else {
				result = mid;
				left = mid + 1;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}


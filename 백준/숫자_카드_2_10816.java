import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < N; idx++) {
			numbers[idx] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < M; idx++) {
			int input = Integer.parseInt(st.nextToken());
			bw.write(upperBound(input) - lowerBound(input) + " ");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static int upperBound(int input) {
		int left = 0;
		int right = N;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (input < numbers[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	static int lowerBound(int input) {
		int left = 0;
		int right = N;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (input <= numbers[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}
}


import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] marble = new int[N];
        
		st = new StringTokenizer(br.readLine());
        long left = 0, right = 0, result = 0;
		for (int idx = 0; idx < N; idx++) {
			marble[idx] = Integer.parseInt(st.nextToken());
			left = Math.max(left, marble[idx]);
			right += marble[idx];
		}

		while (left <= right) {
			long middle = left + (right - left) / 2;

			int count = 1;
			long sum = 0;
			for (int idx = 0; idx < N; idx++) {
				if (count > M) {
					break;
				}

				if (sum + marble[idx] > middle) {
					count++;
					sum = marble[idx];
				} else {
					sum += marble[idx];
				}
			}

			if (count > M) {
				left = middle + 1;
			} else {
				result = middle;
				right = middle - 1;
			}
		}

		System.out.println(result);
		br.close();
	}
}


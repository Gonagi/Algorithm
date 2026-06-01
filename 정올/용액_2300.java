import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < N; idx++) {
			number[idx] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);

		int left = 0, right = N - 1, min = Integer.MAX_VALUE;
		int leftResult = 0, rightResult = 0;
		while (left < right) {
			int sum = number[left] + number[right];
			int absSum = Math.abs(sum);

			if (min > absSum) {
				min = absSum;
				leftResult = number[left];
				rightResult = number[right];
			}
			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(leftResult).append(' ').append(rightResult);
		System.out.println(sb);
		br.close();
	}
}


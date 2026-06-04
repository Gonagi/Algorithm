import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];
		for (int idx = 0; idx < N; idx++) {
			sushi[idx] = Integer.parseInt(br.readLine());
		}

		int[] check = new int[d + 1];
		int count = 0, max = 0;
		for (int cur = 0; cur < k; cur++) {
			check[sushi[cur]]++;
		}

		for (int idx = 1; idx <= d; idx++) {
			if (check[idx] > 0) {
				count++;
			}
		}

		max = check[c] == 0 ? count + 1 : count;

		int left = 0, right = k - 1;
		while (left < N) {
			check[sushi[left]]--;
			if (check[sushi[left]] == 0) {
				count--;
			}

			left++;
			right++;
			if (right == N) {
				right = 0;
			}

			if (check[sushi[right]] == 0) {
				count++;
			}

			check[sushi[right]]++;

			if (check[c] == 0) {
				max = Math.max(max, count + 1);
			} else {
				max = Math.max(max, count);
			}
		}

		System.out.println(max);
		br.close();
	}
}


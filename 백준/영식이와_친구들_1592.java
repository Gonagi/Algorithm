import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] receive = new int[N + 1];

		int cur = 1;
		receive[cur]++;
		for (int count = 0;; count++) {
			for (int idx = 1; idx <= N; idx++) {
				if (receive[idx] == M) {
					System.out.println(count);
					br.close();
					return;
				}
			}

			if (receive[cur] % 2 == 0) {
				cur = cur - L <= 0 ? N + cur - L : cur - L;
			} else {
				cur = cur + L > N ? cur + L - N : cur + L;
			}
			receive[cur]++;
		}
	}
}

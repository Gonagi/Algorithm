import java.io.*;
import java.util.*;

public class Main {
	static class Confetti implements Comparable<Confetti> {
		int width, height;

		public Confetti(int width, int height) {
			this.width = width;
			this.height = height;
		}

		@Override
		public int compareTo(Confetti o) {
			if (this.width == o.width) {
				return Integer.compare(o.height, this.height);
			}
			return Integer.compare(o.width, this.width);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		Confetti[] confetti = new Confetti[count];

		for (int idx = 0; idx < count; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			if (width < height) {
				confetti[idx] = new Confetti(height, width);
			} else {
				confetti[idx] = new Confetti(width, height);
			}
		}

		Arrays.sort(confetti);

		int[] dp = new int[count];
		Arrays.fill(dp, 1);

		int answer = 1;
		for (int idx = 0; idx < count; idx++) {
			for (int idx2 = 0; idx2 < idx; idx2++) {
				if (confetti[idx2].width >= confetti[idx].width && confetti[idx2].height >= confetti[idx].height) {
					dp[idx] = Math.max(dp[idx], dp[idx2] + 1);
				}
			}
			answer = Math.max(answer, dp[idx]);
		}

		System.out.println(answer);
		br.close();
	}
}


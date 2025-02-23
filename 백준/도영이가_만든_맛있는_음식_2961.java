import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int[] sours, bitters;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		sours = new int[N];
		bitters = new int[N];

		for (int idx = 0; idx < N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sours[idx] = Integer.parseInt(st.nextToken());
			bitters[idx] = Integer.parseInt(st.nextToken());
		}
		result = Integer.MAX_VALUE;
		backtrack(0, 0, 1, 0);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static void backtrack(int idx, int pickCount, long totalSour, long totalBitter) {
		if (idx == N) {
			if (pickCount > 0) {
				result = Math.min(result, (int) Math.abs((totalSour - totalBitter)));
			}
			return;
		}

		backtrack(idx + 1, pickCount, totalSour, totalBitter);

		long nextSour = totalSour * sours[idx];
		long nextBitter = totalBitter + bitters[idx];
		backtrack(idx + 1, pickCount + 1, nextSour, nextBitter);
	}
}


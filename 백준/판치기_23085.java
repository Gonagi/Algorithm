import java.io.*;
import java.util.*;

public class Main {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int tCount = 0;
		char[] inputs = br.readLine().toCharArray();
		for (char c : inputs) {
			if (c == 'T') {
				tCount++;
			}
		}
		if (tCount == N) {
			System.out.println(0);
		} else {
			System.out.println(bfs(tCount));
		}
		br.close();
	}

	public static int bfs(int tCount) {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { tCount, 0 });
		boolean[] visited = new boolean[N + 1];
		visited[tCount] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int t = cur[0];
			int h = N - t;
			int count = cur[1];

			if (t == N) {
				return count;
			}

			for (int idx = 0; idx <= K; idx++) {
				int selectT = idx;
				int selectH = K - idx;
				int nextT = t - selectT + selectH;

				if (selectT > t || selectH > h || visited[nextT]) {
					continue;
				}
				visited[nextT] = true;
				que.add(new int[] { nextT, count + 1 });
			}
		}
		return -1;
	}
}

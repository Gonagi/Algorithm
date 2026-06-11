import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int p, f, s, v, c;

		public Node(int p, int f, int s, int v, int c) {
			this.p = p;
			this.f = f;
			this.s = s;
			this.v = v;
			this.c = c;
		}
	}

	static int N, mp, mf, ms, mv, min = Integer.MAX_VALUE;
	static Node[] nodes;
	static boolean[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());

		nodes = new Node[N];
		result = new boolean[N];
		for (int idx = 0; idx < N; idx++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes[idx] = new Node(p, f, s, v, c);
		}

		dfs(0, 0, 0, 0, 0, 0, new boolean[N]);

		if (min == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(min).append('\n');
			for (int idx = 0; idx < N; idx++) {
				if (result[idx]) {
					sb.append(idx + 1).append(' ');
				}
			}
		}

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int cur, int curP, int curF, int curS, int curV, int curC, boolean[] check) {
		if (min < curC) {
			return;
		}

		if (mp <= curP && mf <= curF && ms <= curS && mv <= curV) {
			min = Math.min(min, curC);

			result = new boolean[N];
			for (int idx = 0; idx < N; idx++) {
				if (check[idx]) {
					result[idx] = true;
				}
			}

			return;
		}

		if (cur >= N) {
			return;
		}

		dfs(cur + 1, curP, curF, curS, curV, curC, check);
		check[cur] = true;
		dfs(cur + 1, curP + nodes[cur].p, curF + nodes[cur].f, curS + nodes[cur].s, curV + nodes[cur].v,
				curC + nodes[cur].c, check);
		check[cur] = false;
	}
}


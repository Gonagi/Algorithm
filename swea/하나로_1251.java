import java.io.*;
import java.util.*;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int from, to;
		Double tariff;

		public Edge(int from, int to, Double tariff) {
			super();
			this.from = from;
			this.to = to;
			this.tariff = tariff;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.tariff, o.tariff);
		}
	}

	static int N, curIdx;
	static Double E;
	static int[] xs, ys;
	static int[] parent;
	static Edge[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			curIdx = 0;
			xs = new int[N];
			ys = new int[N];
			edges = new Edge[N * (N - 1) / 2];
			StringTokenizer xSt = new StringTokenizer(br.readLine());
			StringTokenizer ySt = new StringTokenizer(br.readLine());
			E = Double.parseDouble(br.readLine());
			for (int idx = 0; idx < N; idx++) {
				xs[idx] = Integer.parseInt(xSt.nextToken());
				ys[idx] = Integer.parseInt(ySt.nextToken());
			}

			dfs(0, 0, new int[2]);

			Arrays.sort(edges);
			init();

			double result = 0;
			int count = 0;
			for (Edge edge : edges) {
				if (union(edge.from, edge.to)) {
					result += edge.tariff;
					if (++count == N - 1) {
						break;
					}
				}
			}

			bw.write("#" + testCase + " " + Math.round(result) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}

	static void dfs(int count, int start,int[] pair) {
		if (count == 2) {
			int from = pair[0];
			int to = pair[1];
			long yDistance = Math.abs(ys[from] - ys[to]);
			long xDistance = Math.abs(xs[from] - xs[to]);
			edges[curIdx++] = new Edge(from, to, (Math.pow(yDistance, 2) + Math.pow(xDistance, 2)) * E);
			return;
		}
		for (int idx = start; idx < N; idx++) {
			pair[count] = idx;
			dfs(count + 1, idx + 1, pair);
		}
	}

	static void init() {
		parent = new int[N];
		for (int idx = 0; idx < N; idx++) {
			parent[idx] = idx;
		}
	}

	static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) {
			return false;
		}
		parent[bRoot] = aRoot;
		return true;
	}
}


import java.io.*;
import java.util.*;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Solution.Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int V, E;
	static int[] parents;
	static Edge[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edges = new Edge[E];
			for (int idx = 0; idx < E; idx++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				edges[idx] = new Edge(A, B, C);
			}
			Arrays.sort(edges);
			init();

			long result = 0;
			int count = 0;
			for (Edge edge : edges) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;
					count++;
					if (count == V - 1) {
						break;
					}
				}
			}

			bw.write("#" + testCase + " " + result + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static void init() {
		parents = new int[V + 1];
		for (int node = 1; node <= V; node++) {
			parents[node] = node;
		}
	}

	private static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
}


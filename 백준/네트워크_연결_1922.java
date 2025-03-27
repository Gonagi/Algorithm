import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int from, to, value;

		public Edge(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.value, o.value);
		}
	}

	static int N, M;
	static int[] parents;
	static Edge[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edges = new Edge[M];

		for (int idx = 0; idx < M; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[idx] = new Edge(a, b, c);
		}

		Arrays.sort(edges);
		init();

		int result = 0, count = 0;
		for (Edge edge : edges) {
			if (count == N - 1) {
				break;
			}
			if (union(edge.from, edge.to)) {
				result += edge.value;
				count++;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	private static void init() {
		parents = new int[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			parents[idx] = idx;
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


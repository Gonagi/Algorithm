import java.io.*;
import java.util.*;

class Solution {
	static int n, m;
	static int[] parents;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			init();
			bw.write("#" + testCase + " ");

			for (int idx = 0; idx < m; idx++) {
				st = new StringTokenizer(br.readLine());
				int operator = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (operator == 0) {
					union(a, b);
				} else {
					if (find(a) == find(b)) {
						bw.write("1");
					} else {
						bw.write("0");
					}
				}

			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static void init() {
		parents = new int[n + 1];
		for (int node = 1; node <= n; node++) {
			parents[node] = node;
		}
	}

	static int find(int node) {
		if (node == parents[node]) {
			return node;
		}
		return parents[node] = find(parents[node]);
	}

	static void union(int node1, int node2) {
		int node1Parent = find(node1);
		int node2Parent = find(node2);

		if (node1Parent != node2Parent) {
			parents[node2Parent] = node1Parent;
		}
	}
}


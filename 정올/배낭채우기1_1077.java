import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int w, p;

		public Node(int w, int p) {
			this.w = w;
			this.p = p;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		Node[] nodes = new Node[N];
		for (int idx = 0; idx < N; idx++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			nodes[idx] = new Node(w, p);
		}

		int[] dp = new int[W + 1];

		for (Node node : nodes) {
			for (int weight = node.w; weight <= W; weight++) {
				dp[weight] = Math.max(dp[weight], dp[weight - node.w] + node.p);
			}
		}

		System.out.println(dp[W]);
		br.close();
	}
}


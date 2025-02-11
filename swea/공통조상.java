package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int V, E, N1, N2;
	static Node[] nodes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			N1 = Integer.parseInt(st.nextToken());
			N2 = Integer.parseInt(st.nextToken());
			nodes = new Node[V + 1];
			for (int idx = 1; idx <= V; idx++) {
				nodes[idx] = new Node();
			}

			st = new StringTokenizer(br.readLine());
			for (int idx = 0; idx < E; idx++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				nodes[c].parent = p;
				nodes[p].children.add(c);
			}

			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();

			checkParent(N1, list1);
			checkParent(N2, list2);

			int commonParent = 0;
			for (int idx = 0; idx < list1.size(); idx++) {
				if (!list1.get(idx).equals(list2.get(idx))) {
					break;
				}
				commonParent = list1.get(idx);
			}

			int size = getChildrenSize(commonParent);

			StringBuilder sb = new StringBuilder("#");
			sb.append(testCase).append(' ').append(commonParent).append(' ').append(size);
			System.out.println(sb);
		}
		br.close();
	}

	private static int getChildrenSize(int cur) {
		int size = 1;
		for (int child : nodes[cur].children) {
			size += getChildrenSize(child);
		}
		return size;
	}

	private static void checkParent(int n, List<Integer> list) {
		if (n == 0) {
			return;
		}
		checkParent(nodes[n].parent, list);
		list.add(n);
	}

	static class Node {
		List<Integer> children;
		int parent;

		public Node() {
			children = new ArrayList<>();
			parent = 0;
		}
	}
}


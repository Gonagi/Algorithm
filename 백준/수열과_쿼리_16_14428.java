import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int value;
		int index;

		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	static int N, M;
	static int[] numbers;
	static Node[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N + 1];
		tree = new Node[N * 4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 1; idx <= N; idx++) {
			numbers[idx] = Integer.parseInt(st.nextToken());
		}
		init(1, N, 1);

		M = Integer.parseInt(br.readLine());
		for (int idx = 0; idx < M; idx++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				update(a, b, 1, 1, N);
			} else {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				Node result = print(a, b, 1, 1, N);
				bw.write(result.index + "\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static Node init(int left, int right, int node) {
		if (left == right) {
			return tree[node] = new Node(numbers[left], left);
		}
		int mid = (left + right) / 2;
		Node leftNode = init(left, mid, node * 2);
		Node rightNode = init(mid + 1, right, node * 2 + 1);
		if (leftNode.value > rightNode.value) {
			return tree[node] = rightNode;
		}
		return tree[node] = leftNode;
	}

	static Node update(int idx, int newValue, int node, int nodeLeft, int nodeRight) {
		if (nodeRight < idx || idx < nodeLeft) {
			return tree[node];
		}
		if (nodeLeft == nodeRight) {
			return tree[node] = new Node(newValue, idx);
		}

		int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
		Node leftNode = update(idx, newValue, node * 2, nodeLeft, mid);
		Node rightNode = update(idx, newValue, node * 2 + 1, mid + 1, nodeRight);
		if (leftNode.value > rightNode.value) {
			return tree[node] = rightNode;
		}
		return tree[node] = leftNode;
	}

	static Node print(int left, int right, int node, int nodeLeft, int nodeRight) throws Exception {
		if (nodeRight < left || right < nodeLeft) {
			return new Node(Integer.MAX_VALUE, 0);
		}
		if (left <= nodeLeft && nodeRight <= right) {
			return tree[node];
		}
		int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
		Node leftNode = print(left, right, node * 2, nodeLeft, mid);
		Node rightNode = print(left, right, node * 2 + 1, mid + 1, nodeRight);
		if (leftNode.value > rightNode.value) {
			return rightNode;
		} else {
			return leftNode;
		}
	}
}


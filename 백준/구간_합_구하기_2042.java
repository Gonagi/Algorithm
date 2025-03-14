import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static long[] numbers, tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		numbers = new long[N + 1];
		tree = new long[N * 4];

		for (int idx = 1; idx <= N; idx++) {
			numbers[idx] = Long.parseLong(br.readLine());
		}

		init(1, N, 1);

		for (int idx = 0; idx < M + K; idx++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				int changeIdx = Integer.parseInt(st.nextToken());
				long changeValue = Long.parseLong(st.nextToken());
				update(changeIdx, changeValue, 1, 1, N);
			} else {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				bw.write(sum(start, end, 1, 1, N) + "\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static long init(int left, int right, int node) {
		if (left == right) {
			return tree[node] = numbers[left];
		}

		int mid = (left + right) / 2;
		long leftValue = init(left, mid, node * 2);
		long rightValue = init(mid + 1, right, node * 2 + 1);
		return tree[node] = leftValue + rightValue;
	}

	static long update(int idx, long newValue, int node, int nodeLeft, int nodeRight) {
		if (nodeRight < idx || idx < nodeLeft) {
			return tree[node];
		}
		if (nodeLeft == nodeRight) {
			return tree[node] = newValue;
		}
		int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
		long leftValue = update(idx, newValue, node * 2, nodeLeft, mid);
		long rightValue = update(idx, newValue, node * 2 + 1, mid + 1, nodeRight);
		tree[node] = leftValue + rightValue;
		return tree[node];
	}

	static long sum(int left, int right, int node, int nodeLeft, int nodeRight) {
		if (right < nodeLeft || left > nodeRight) {
			return 0;
		}
		if (left <= nodeLeft && nodeRight <= right) {
			return tree[node];
		}
		int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
		long leftValue = sum(left, right, node * 2, nodeLeft, mid);
		long rightValue = sum(left, right, node * 2 + 1, mid + 1, nodeRight);
		return leftValue + rightValue;
	}
}


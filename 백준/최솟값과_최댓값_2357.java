import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] numbers, smallTree, bigTree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N + 1];
		smallTree = new int[N * 4];
		bigTree = new int[N * 4];
		Arrays.fill(smallTree, Integer.MAX_VALUE);
		Arrays.fill(bigTree, Integer.MIN_VALUE);

		for (int idx = 1; idx <= N; idx++) {
			numbers[idx] = Integer.parseInt(br.readLine());
		}

		smallInit(1, N, 1);
		bigInit(1, N, 1);

		for (int idx = 1; idx <= M; idx++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			bw.write(smallCheck(left, right, 1, 1, N) + " " + bigCheck(left, right, 1, 1, N) + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static int smallInit(int left, int right, int node) {
		if (left == right) {
			return smallTree[node] = numbers[left];
		}
		int mid = (left + right) / 2;
		int leftValue = smallInit(left, mid, node * 2);
		int rightValue = smallInit(mid + 1, right, node * 2 + 1);
		smallTree[node] = leftValue < rightValue ? leftValue : rightValue;
		return smallTree[node];
	}

	static int bigInit(int left, int right, int node) {
		if (left == right) {
			return bigTree[node] = numbers[left];
		}
		int mid = (left + right) / 2;
		int leftValue = bigInit(left, mid, node * 2);
		int rightValue = bigInit(mid + 1, right, node * 2 + 1);
		bigTree[node] = rightValue < leftValue ? leftValue : rightValue;
		return bigTree[node];
	}

	static int smallCheck(int left, int right, int node, int nodeLeft, int nodeRight) {
		if (left > nodeRight || right < nodeLeft) {
			return Integer.MAX_VALUE;
		}
		if (left <= nodeLeft && nodeRight <= right) {
			return smallTree[node];
		}
		int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
		int leftValue = smallCheck(left, right, node * 2, nodeLeft, mid);
		int rightValue = smallCheck(left, right, node * 2 + 1, mid + 1, nodeRight);
		return Math.min(leftValue, rightValue);
	}

	static int bigCheck(int left, int right, int node, int nodeLeft, int nodeRight) {
		if (left > nodeRight || right < nodeLeft) {
			return Integer.MIN_VALUE;
		}
		if (left <= nodeLeft && nodeRight <= right) {
			return bigTree[node];
		}
		int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
		int leftValue = bigCheck(left, right, node * 2, nodeLeft, mid);
		int rightValue = bigCheck(left, right, node * 2 + 1, mid + 1, nodeRight);
		return Math.max(leftValue, rightValue);
	}
}


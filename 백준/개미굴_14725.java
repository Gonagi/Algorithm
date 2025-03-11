import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		Map<String, Node> childNode;
		boolean visit;
		boolean terminate;

		public Node() {
			this.childNode = new TreeMap<>();
			this.visit = false;
			this.terminate = false;
		}

	}

	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		Node startNode = new Node();
		for (int idx = 0; idx < N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			insert(st, startNode);
		}

		for (String key : startNode.childNode.keySet()) {
			print(startNode.childNode.get(key), 1, key, bw);
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

	static void insert(StringTokenizer st, Node startNode) {
		Node curNode = startNode;
		for (int i = 0; i < K; i++) {
			String food = st.nextToken();
			curNode.childNode.putIfAbsent(food, new Node());
			curNode = curNode.childNode.get(food);
		}
		curNode.terminate = true;
	}

	static void print(Node curNode, int depth, String string, BufferedWriter bw) throws Exception {
		Map<String, Node> childNode = curNode.childNode;
		curNode.visit = true;
		for (int idx = 1; idx < depth; idx++) {
			bw.write("--");
		}
		bw.write(string + "\n");

		for (String key : childNode.keySet()) {
			Node nextNode = childNode.get(key);
			if (nextNode.visit) {
				continue;
			}
			nextNode.visit = true;
			print(nextNode, depth + 1, key, bw);
		}
	}
}


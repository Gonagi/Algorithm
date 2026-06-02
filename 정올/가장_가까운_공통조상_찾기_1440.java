import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<Integer>[] graph;
	static int[] parent, checkArr, height;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		graph = new ArrayList[N + 1];
		parent = new int[N + 1];
		checkArr = new int[N + 1];
		height = new int[N + 1];
		visited = new boolean[N + 1];

		for (int idx = 1; idx <= N; idx++) {
			graph[idx] = new ArrayList<>();
		}

		for (int idx = 0; idx < N - 1; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			parent[to] = from;
			checkArr[to]++;
		}

		int root = 0;
		for (int num = 1; num <= N; num++) {
			if (checkArr[num] == 0) {
				root = num;
				break;
			}
		}

		Queue<Integer> que = new ArrayDeque<>();
		que.add(root);
		visited[root] = true;

		int level = 0;
		while (!que.isEmpty()) {
			int size = que.size();

			for (int s = 0; s < size; s++) {
				int cur = que.poll();
				for (int next : graph[cur]) {
					if (visited[next]) {
						continue;
					}
					que.add(next);
					visited[next] = true;
					height[next] = level + 1;
				}
			}

			level++;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		if (height[from] > height[to]) {
			while (height[from] != height[to]) {
				from = parent[from];
			}
		} else if (height[from] < height[to]) {
			while (height[from] != height[to]) {
				to = parent[to];
			}
		}

		while (from != to) {
			from = parent[from];
			to = parent[to];
		}

		System.out.println(from);
		br.close();
	}
}


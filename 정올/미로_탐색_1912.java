import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();
	static int N, M, checkCount;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			graph[idx] = new ArrayList<>();
		}
		visited = new boolean[N + 1];

		for (int idx = 0; idx < M; idx++) {
			st = new StringTokenizer(br.readLine());
			int room1 = Integer.parseInt(st.nextToken());
			int room2 = Integer.parseInt(st.nextToken());
			graph[room1].add(room2);
			graph[room2].add(room1);
		}

		for (int idx = 1; idx <= N; idx++) {
			Collections.sort(graph[idx]);
		}

		dfs(1);

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int cur) {
		if (checkCount == N) {
			return;
		}

		sb.append(cur).append(' ');
		checkCount++;
		visited[cur] = true;

		for (int next : graph[cur]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next);
			}
		}
	}
}


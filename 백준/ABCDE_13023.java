import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static boolean check;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = false;
		list = new ArrayList[N];
		visited = new boolean[N];

		for (int idx = 0; idx < N; idx++) {
			list[idx] = new ArrayList<>();
		}
		for (int idx = 0; idx < M; idx++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		int result = 0;
		for (int node = 0; node < N; node++) {
			if (check) {
				result = 1;
				break;
			}
			Arrays.fill(visited, false);
			visited[node] = true;
			DFS(node, 0);
		}

		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	static void DFS(int node, int count) {
		if (count == 4) {
			check = true;
			return;
		}
		for (int next : list[node]) {
			if (!visited[next] && !check) {
				visited[next] = true;
				DFS(next, count + 1);
				visited[next] = false;
			}
		}
	}
}


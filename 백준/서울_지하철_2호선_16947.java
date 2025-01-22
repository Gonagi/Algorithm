import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<Integer>[] graphs;
	static int[] count;
	static boolean[] check, visited;
	static boolean find;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = new int[N + 1];
		check = new boolean[N + 1];
		visited = new boolean[N+1];
		graphs = new ArrayList[N + 1];
		for (int idx = 0; idx < N + 1; idx++) {
			graphs[idx] = new ArrayList<>();
		}

		for (int idx = 1; idx <= N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graphs[from].add(to);
			graphs[to].add(from);
		}

		for (int station = 1; station <= N; station++) {
			dfs(station, station, station);
			if (find) {
				break;
			}
		}

		for (int station = 1; station <= N; station++) {
			if (check[station]) {
				continue;
			}
			bfs(station);
		}

		StringBuilder sb = new StringBuilder();
		for(int idx = 1; idx <= N; idx++) {
			sb.append(count[idx]).append(" ");
		}
		System.out.println(sb);
		
		br.close();
	}

	static void dfs(int start, int prev, int cur) {
		check[cur] = true;
		for (int next : graphs[cur]) {
			if (check[next] && start == next && prev != start) {
				find = true;
				return;
			} else if (!check[next]) {
				dfs(start, cur, next);
				if (find) {
					return;
				}
			}
		}
		check[cur] = false;
	}

	static void bfs(int station) {
		Arrays.fill(visited, false);
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[]{station, 0});
		visited[station] = true;

		while (!que.isEmpty()) {
			int[] node = que.poll();
			int cur = node[0];
			int curDistance = node[1];
			
			for (int next : graphs[cur]) {
				if (check[next]) {
					count[station] = curDistance + 1;
					return;
				}
				if(!visited[next]) {
				que.add(new int[] {next, curDistance + 1});
				visited[next] = true;
				}
			}
		}
	}
}

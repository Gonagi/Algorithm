// BFS
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Integer>[] heights;
	static int[] smallerCount;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		heights = new ArrayList[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			heights[idx] = new ArrayList<>();
		}
		smallerCount = new int[N + 1];

		for (int idx = 1; idx <= M; idx++) {
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken());
			int big = Integer.parseInt(st.nextToken());
			heights[small].add(big);
			smallerCount[big]++;
		}

		Queue<Integer> que = new ArrayDeque<>();
		for (int p = 1; p <= N; p++) {
			if (smallerCount[p] == 0) {
				que.add(p);
			}
		}

		while (!que.isEmpty()) {
			int curPerson = que.poll();
			bw.write(curPerson + " ");

			for (int nextPerson : heights[curPerson]) {
				smallerCount[nextPerson]--;
				if (smallerCount[nextPerson] == 0) {
					que.add(nextPerson);
				}
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}

// DFS
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Integer>[] heights;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		heights = new ArrayList[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			heights[idx] = new ArrayList<>();
		}
		visited = new boolean[N + 1];

		for (int idx = 1; idx <= M; idx++) {
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken());
			int big = Integer.parseInt(st.nextToken());
			heights[big].add(small);
		}

		for (int person = 1; person <= N; person++) {
			if (!visited[person]) {
				dfs(person, bw);
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int person, BufferedWriter bw) throws Exception {
		visited[person] = true;

		for (int nextPerson : heights[person]) {
			if (!visited[nextPerson]) {
				dfs(nextPerson, bw);
			}
		}
		bw.write(person + " ");
	}
}


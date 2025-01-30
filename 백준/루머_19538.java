import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[] result, rumorCount;
	static Queue<Integer> que;
	static List<List<Integer>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		bfs();
		printResult();
		br.close();
	}

	private static void printResult() {
		StringBuilder sb = new StringBuilder();
		for (int idx = 1; idx <= N; idx++) {
			sb.append(result[idx]).append(" ");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int num = que.poll();
			int time = result[num];

			for (int next : list.get(num)) {
				if (result[next] != -1) {
					continue;
				}
				int totalNeighbors = list.get(next).size();
				rumorCount[next]++;
				if (rumorCount[next] * 2 < totalNeighbors) {
					continue;
				}
				que.add(next);
				result[next] = time + 1;
			}
		}
	}

	private static void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		result = new int[N + 1];
		Arrays.fill(result, -1);
		rumorCount = new int[N + 1];
		list = new ArrayList<>();
		for (int idx = 0; idx < N + 1; idx++) {
			list.add(new ArrayList<>());
		}

		for (int cur = 1; cur <= N; cur++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int next = Integer.parseInt(st.nextToken());
				if (next == 0) {
					break;
				}
				list.get(cur).add(next);
			}
		}

		M = Integer.parseInt(br.readLine());
		que = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 1; idx <= M; idx++) {
			int num = Integer.parseInt(st.nextToken());
			que.add(num);
			result[num] = 0;
		}
	}
}

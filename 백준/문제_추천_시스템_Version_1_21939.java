import java.io.*;
import java.util.*;

public class Main {
	static class Problem {
		int number, level;

		public Problem(int number, int level) {
			this.number = number;
			this.level = level;
		}

	}

	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		TreeSet<Problem> set = new TreeSet<>((t1, t2) -> {
			if (t1.level == t2.level) {
				return t1.number - t2.number;
			}
			return t1.level - t2.level;
		});

		Map<Integer, Integer> map = new HashMap<>();

		for (int idx = 0; idx < N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int problem = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			set.add(new Problem(problem, level));
			map.put(problem, level);
		}

		M = Integer.parseInt(br.readLine());
		for (int idx = 0; idx < M; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if (input.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				Problem problem = new Problem(P, L);
				set.add(problem);
				map.put(P, L);
			} else if (input.equals("recommend")) {
				if (st.nextToken().equals("1")) {
					bw.write(set.last().number + "\n");
				} else {
					bw.write(set.first().number + "\n");
				}
			} else if (input.equals("solved")) {
				int s = Integer.parseInt(st.nextToken());
				int level = map.get(s);
				set.remove(new Problem(s, level));
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}


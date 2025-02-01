import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 1; testCase <= 10; testCase++) {
			List<String> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int idx = 0; idx < N; idx++) {
				list.add(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int idx = 0; idx < M; idx++) {
				String string = st.nextToken();
				if (string.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int idx2 = 0; idx2 < y; idx2++) {
						list.add(x + idx2, st.nextToken());
					}
				} else if (string.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int idx2 = 0; idx2 < y; idx2++) {
						list.remove(x);
					}
				} else {
					int y = Integer.parseInt(st.nextToken());
					for (int idx2 = 0; idx2 < y; idx2++) {
						list.add(st.nextToken());
					}
				}
			}

			StringBuilder sb = new StringBuilder("#");
			sb.append(testCase).append(" ");
			for (int idx = 0; idx < 10; idx++) {
				sb.append(list.get(idx)).append(" ");
			}
			System.out.println(sb);
		}
		br.close();
	}
}

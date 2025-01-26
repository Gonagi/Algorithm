import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			boolean[] visited = new boolean[10000];
			Queue<Info> que = new ArrayDeque<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			visited[A] = true;
			que.add(new Info(A, ""));

			while (!que.isEmpty()) {
				Info cur = que.poll();
				int curNum = cur.num;
				String curCommand = cur.command;

				if (curNum == B) {
					System.out.println(curCommand);
					break;
				}

				int DNum = (curNum * 2) > 9999 ? (curNum * 2) % 10000 : curNum * 2;
				if (!visited[DNum]) {
					visited[DNum] = true;
					que.add(new Info(DNum, curCommand + "D"));
				}
				
				int SNum = (curNum - 1) < 0 ? 9999 : curNum - 1;
				if (!visited[SNum]) {
					visited[SNum] = true;
					que.add(new Info(SNum,curCommand + "S"));
				}

				int LNum = (curNum % 1000) * 10 + curNum / 1000;
				if (!visited[LNum]) {
					visited[LNum] = true;
					que.add(new Info(LNum, curCommand + "L"));
				}

				int RNum = (curNum % 10) * 1000 + (curNum / 10);
				if (!visited[RNum]) {
					visited[RNum] = true;
					que.add(new Info(RNum, curCommand + "R"));
				}
			}
		}
        br.close();
	}
	
	static class Info{
		int num;
		String command;
		
		public Info(int num, String command) {
			this.num = num;
			this.command = command;
		}
	}
}

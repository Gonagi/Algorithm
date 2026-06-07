import java.io.*;
import java.util.*;

public class Main {
	static int[] door, order;
	static boolean[] openDoor;
	static int orderCount, result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		door = new int[count + 1];
		openDoor = new boolean[count + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int open1 = Integer.parseInt(st.nextToken());
		int open2 = Integer.parseInt(st.nextToken());

		orderCount = Integer.parseInt(br.readLine());
		order = new int[orderCount];
		for (int idx = 0; idx < orderCount; idx++) {
			order[idx] = Integer.parseInt(br.readLine());
		}

		dfs(0, 0, open1, open2);

		System.out.println(result);
		br.close();
	}

	private static void dfs(int cur, int count, int open1, int open2) {
		if (cur == orderCount) {
			result = Math.min(result, count);
			return;
		}

		int distance1 = Math.abs(open1 - order[cur]);
		int distance2 = Math.abs(open2 - order[cur]);

		dfs(cur + 1, count + distance1, order[cur], open2);
		dfs(cur + 1, count + distance2, open1, order[cur]);
	}
}


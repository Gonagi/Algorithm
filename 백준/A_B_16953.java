import java.io.*;
import java.util.*;

public class Main {
	static int A, B;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		dfs(A, 1);
		result = result == Integer.MAX_VALUE ? -1 : result;
		System.out.println(result);
		br.close();
	}

	public static void dfs(long number, int count) {
		if (number == B) {
			result = Math.min(result, count);
			return;
		}
		if (number < B) {
			dfs(number * 2, count + 1);
			dfs(number * 10 + 1, count + 1);
		}

	}
}

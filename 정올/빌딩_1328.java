import java.io.*;
import java.util.*;

public class Main {
	static class Building {
		int index;
		int height;

		public Building(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());

		int[] heights = new int[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			heights[idx] = Integer.parseInt(br.readLine().trim());
		}

		int[] result = new int[N + 1];
		Deque<Building> stack = new ArrayDeque<>();

		for (int idx = N; idx >= 1; idx--) {
			int currentHeight = heights[idx];

			while (!stack.isEmpty() && stack.peek().height <= currentHeight) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				result[idx] = 0;
			} else {
				result[idx] = stack.peek().index;
			}

			stack.push(new Building(idx, currentHeight));
		}

		for (int idx = 1; idx <= N; idx++) {
			sb.append(result[idx]).append('\n');
		}

		System.out.print(sb);
		br.close();
	}
}


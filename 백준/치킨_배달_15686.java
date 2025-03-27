import java.io.*;
import java.util.*;

public class Main {
	static class Direction {
		int y, x;

		public Direction(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int N, M, result;
	static int[][] map;
	static List<Direction> chickens, houses;
	static List<Integer> distances;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		map = new int[N][N];
		chickens = new ArrayList<>();
		houses = new ArrayList<>();
		distances = new ArrayList<>();

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 1) {
					houses.add(new Direction(y, x));
				} else if (map[y][x] == 2) {
					chickens.add(new Direction(y, x));
				}
			}
		}
		
		DFS(0, 0, new Direction[M]);

		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	private static void DFS(int count, int start, Direction[] curChicken) {
		if (count == M) {
			int sum = 0;
			for (Direction house : houses) {
				int min = Integer.MAX_VALUE;
				for (Direction chicken : curChicken) {
					int distance = Math.abs(house.y - chicken.y) + Math.abs(house.x - chicken.x);
					min = Math.min(distance, min);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}
		for (int idx = start; idx < chickens.size(); idx++) {
			curChicken[count] = chickens.get(idx);
			DFS(count + 1, idx + 1, curChicken);
		}
	}
}


import java.util.*;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		int T = sc.nextInt();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			System.out.printf("#%d %d\n", testCase, play());
		}
	}
	
	private static int play() {
		int[][] map = inputMap();
		int max = 0;
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				int plusShapeCount = calPlusShape(map, y, x);
				int multipleShapeCount = calMultipleShape(map, y, x);
				max = Math.max(max, Math.max(plusShapeCount, multipleShapeCount));
			}
		}
		return max;
	}

	private static int[][] inputMap() {
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[][] map = new int[N][N];
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				map[y][x] = sc.nextInt();
			}
		}
		
		return map;
	}
	
	private static int calPlusShape(final int[][] map, final int calY, final int calX) {
		int sum = 0;
		
        for (int i = 1 - M; i < M; i++) {
            if (canMove(calY + i, calX)) 
            	sum += map[calY + i][calX];
            if (canMove(calY, calX + i)) 
            	sum += map[calY][calX + i];
        }
        
		return sum - map[calY][calX];
	}
	
	private static int calMultipleShape(final int[][] map, final int calY, final int calX) {
		int sum = map[calY][calX];
		int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
		
		for(int m = 1; m < M; m++) {
			for(int[] dir : directions) {
				int nextY = calY + m * dir[0];
				int nextX = calX + m * dir[1];
				if(canMove(nextY, nextX))
					sum += map[nextY][nextX];
			}
		}
		
		return sum;	
	}
	
	private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
	}
}

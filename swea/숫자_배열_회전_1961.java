import java.util.*;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[][] board;
	
	public static void main(String[] args) throws Exception{
		int T = sc.nextInt();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			board = new int[8][8];
			
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					board[y][x] = sc.nextInt();
				}
			}
			printResult(testCase);
		}
	}

	private static void printResult(final int testCase) {
		System.out.printf("#%d\n", testCase);
		for(int n = 0; n < N; n++) {
			printBoard(n);				
		}
	}
	
	private static void printBoard(final int n) {
		for(int idx = N-1; idx >= 0; idx--) {			
			System.out.printf("%d", board[idx][n]);
		}
		System.out.print(" ");
		
		for(int idx = N-1; idx >= 0; idx--) {			
			System.out.printf("%d", board[N - n -1][idx]);
		}
		System.out.print(" ");
		
		for(int idx = 0; idx <= N-1; idx++) {			
			System.out.printf("%d", board[idx][N - n - 1]);
		}
		System.out.println();
	}
}

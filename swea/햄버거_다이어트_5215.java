import java.util.*;

class Solution
{
	static int[][] info;
	static int max = 0;
	static int N;
	static int limit;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			limit = sc.nextInt();
			info = new int[N][2];

			max = 0;
			
			for(int idx = 0; idx < N; idx++) {
				info[idx][0] = sc.nextInt();
				info[idx][1] = sc.nextInt();
			}
			
			dfs(0, 0, 0);

			System.out.printf("#%d %d\n", test_case, max);
		}
	}
	
	static void dfs(int score, int sum, int check) {
		if(sum > limit) {
			return;
		}
		
		if(max < score) {
			max = score;
		}
		
        for (int i =check; i < N; i++) {
            dfs(score + info[i][0], sum + info[i][1], i + 1);
        }
	}
}

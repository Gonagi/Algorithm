import java.util.*;

public class Main {
	static Direction[] dir = {new Direction(0,1), new Direction(1,0),
						new Direction(0,-1), new Direction(-1, 0)};
	static int n;
	static int[][] map;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			int num = 1;
			map = new int[n][n];
			
			for(int y = 0; y < n; y++) {
				Arrays.fill(map[y], 0);
			}
			
			Direction cur = new Direction(0, 0);
			int d = 0;
			
			while(num <= n * n) {
				map[cur.y][cur.x] = num;

				if(num == n*n)
					break;
				
				Direction next = new Direction(cur.y + dir[d].y, cur.x + dir[d].x);
				if(canMovable(next)) {
					cur = next;
					num++;
				}else {
					d++;
					if(d == 4) {
						d = 0;
					}
				}
			}
			
			System.out.println("#" + test_case);
			for(int y = 0; y < n; y++) {
				for(int x = 0; x < n; x++) {
					System.out.print(map[y][x] + " ");
				}
				System.out.println();
			}
		}
	}
	
	static void dfs(Direction cur, int num) {
		map[cur.y][cur.x] = num;
		if(num == n*n)
			return;

		for(int d = 0; d < 4; d++) {
			Direction next = new Direction(cur.y + dir[d].y, cur.x + dir[d].x);
			if(canMovable(next)) {
				dfs(next, num + 1);
			}
		}
	}
	
	static boolean canMovable(Direction cur) {
		if(cur.y < 0 || cur.y >= n ||  cur.x < 0 || cur.x >= n 
				|| map[cur.y][cur.x]!= 0 )
			return false;
		return true;
	}

	static class Direction{
		int y, x;
		
		Direction(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}

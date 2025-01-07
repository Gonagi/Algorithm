import java.util.*;

public class Solution {
	static final int MAX = 15;
	static final Direction[] DIRECTIONS = {
			new Direction(1,0), new Direction(-1,0), new Direction(0,1), new Direction(0,-1)
	};
	
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int map[][] = new int[MAX][MAX];
	static Direction start, end;
	
	public static void main(String[] args) throws Exception{
		int T = sc.nextInt();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			inputMap();
			bfs(testCase);
		}
	}

	private static void bfs(int testCase) {
		int count[][] = new int[MAX][MAX];
		Queue<Direction> que = new LinkedList<>();
		count[start.y][start.x]++; 
		que.add(start);
		
		while(!que.isEmpty()) {
			Direction cur = que.poll();
			for(Direction dir : DIRECTIONS) {
				Direction next = new Direction(cur.y + dir.y, cur.x + dir.x);
	            if (isInvalidMove(next)) {
	            	continue;
	            }
	            if (isDestination(next, count, cur)) {
	            	break;
	            }
				if(next.y == end.y && next.x == end.x) {
					count[next.y][next.x] = (count[next.y][next.x] == 0) ?
							count[cur.y][cur.x] + 1 : Math.min(count[next.y][next.x], count[cur.y][cur.x] + 1);
					break;
				}
		        if (map[next.y][next.x] == 2) {
	                processPortal(cur, next, count, que);
	                continue;
	            }
	            processNormalMove(cur, next, count, que);
			}
		}
		System.out.printf("#%d %d\n", testCase, count[end.y][end.x] - 1);
	}

	private static void processPortal(final Direction cur, final Direction next, int[][] count, Queue<Direction> que) {
		int waitTime = 0;

		if (count[cur.y][cur.x] % 3 == 1) {
		    waitTime = 3;
		} else if (count[cur.y][cur.x] % 3 == 2) {
		    waitTime = 2;
		} else {
		    waitTime = 1;
		}
		int nextCount = count[cur.y][cur.x] + waitTime;

	    addQue(next, count, que, nextCount);
	}

	private static void processNormalMove(final Direction cur, final Direction next, int[][] count, Queue<Direction> queue) {
	    int nextCount = count[cur.y][cur.x] + 1;

	    addQue(next, count, queue, nextCount);
	}

	private static void addQue(final Direction next, int[][] count, Queue<Direction> queue, int nextCount) {
		if (count[next.y][next.x] == 0 || count[next.y][next.x] > nextCount) {
	        count[next.y][next.x] = nextCount;
	        queue.add(next);
	    }
	}
	
	private static boolean isInvalidMove(final Direction next) {
	    if (next.y >= 0 && next.y < N && next.x >= 0 && next.x < N && map[next.y][next.x] != 1) {
	    	return false;
	    }
	    return true;
	}
	
	private static boolean isDestination(final Direction next, int[][] count, final Direction cur) {
		if(next.y == end.y && next.x == end.x) {
			if(count[next.y][next.x] == 0) {
				count[next.y][next.x] = count[cur.y][cur.x] + 1;
				return true;
			} 
			count[next.y][next.x] = Math.min(count[next.y][next.x], count[cur.y][cur.x] + 1);
			return true;
		}
		return false;
	}
	
	private static void inputMap() {
		N = sc.nextInt();
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				map[y][x] = sc.nextInt();
			}
		}
		
		start = new Direction(sc.nextInt(), sc.nextInt());
		end = new Direction(sc.nextInt(), sc.nextInt());
	}
	
	static class Direction{
		int y,x;
		
		public Direction(final int y, final int x) {
			this.y = y;
			this.x = x;
		}
	}
}

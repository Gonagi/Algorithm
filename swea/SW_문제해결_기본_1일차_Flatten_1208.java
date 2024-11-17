import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int[] heights = new int[100];
			
			for(int idx = 0; idx < 100; idx++) {
				heights[idx] = sc.nextInt();
			}
			Arrays.sort(heights);
			
			for(int idx = 0; idx < N; idx++) {
				if(heights[0] == heights[99]) {
					break;
				}
				heights[0]++;
				heights[99]--;
				Arrays.sort(heights);
			}
			
			System.out.printf("#%d %d\n", test_case, heights[99] - heights[0]);
		}
	}
}

import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int[] height = new int[N];
			int sum = 0;
			
			for(int idx = 0; idx < N; idx++) {
				height[idx] = sc.nextInt();
			}
			
			for(int idx = 2; idx < N-2; idx++) {
				int max = 0;
				for(int i = idx-2; i <= idx + 2; i++) {
					if(i == idx) {
						continue;
					}
					if(max < height[i]) {
						max = height[i];
					}
				}
				if(max < height[idx]) {
					sum += height[idx] - max;
				}
			}	
			System.out.printf("#%d %d\n", test_case, sum);
		}
	}
}

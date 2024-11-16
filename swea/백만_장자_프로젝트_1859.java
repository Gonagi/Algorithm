import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n];			
			long sum = 0;
			
			for(int idx = 0;idx < n; idx++) {
				arr[idx] = sc.nextInt();
			}
			
			int max = 0;
			for(int idx = n-1; idx >= 0; idx--) {
				if(max < arr[idx]) {
					max = arr[idx];
				}
				sum += (max - arr[idx]);	

			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
}

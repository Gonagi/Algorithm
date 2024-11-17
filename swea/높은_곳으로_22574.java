import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			long n = sc.nextInt();
			long p = sc.nextInt();
			long sum = 0;
			
			for(int i = 1; i <= n; i++) {
				sum += i;
				if(sum == p) {
					sum -= 1;
				}
			}
			System.out.println(sum);
		}
	}
}

import java.util.*;

class Solution
{
		public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			int n = sc.nextInt();
			
			for(int count = 1; ; count++) {
				long sum = x + y;
				if(sum > n) {
					System.out.println(count); 
					break;
				}
				if(x < y) {
					x = (int) sum;
				}else {
					y = (int) sum;
				}
			}		
		}
	}
}

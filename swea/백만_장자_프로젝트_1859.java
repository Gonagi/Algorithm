import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] maxArr = new int[n];
			Arrays.fill(arr, 0);
			Arrays.fill(maxArr, 0);
			
			long sum = 0;
			
			for(int idx = 0;idx < n; idx++) {
				int num = sc.nextInt();
				arr[idx] = num;
				maxArr[idx] = num;

				if(idx != 0) {
					if(maxArr[idx-1] < num) {
						for(int i = idx - 1; i >= 0; i--) {
							if(maxArr[i] > num)
								break;
							maxArr[i] = num;
						}
					}
				}
			}
			
			for(int idx = 0; idx < n; idx++) {
				if(arr[idx] < maxArr[idx]) {
					sum += (maxArr[idx] - arr[idx]);
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int total = (1 << 10) -1;
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int visited = 0;
			int k = 0;
			
			for( k = 1; ; k++) {
				char[] nums = String.valueOf(N*k).toCharArray();
				
				for(char num : nums) {
					int curNum = Character.getNumericValue(num);
					visited |= (1 << curNum);
				}
				
				if(visited == total) {
					break;
				}
			}
            System.out.println("#" + testCase + " " + N*k);
		}
		br.close();
    }
}

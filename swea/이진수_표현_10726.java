import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int check = (1 << N) - 1;
			int cal = M & check;
			StringBuilder sb = new StringBuilder();
			if (cal == check) {
			    sb.append("#").append(testCase).append(" ON\n");
			} else {
			    sb.append("#").append(testCase).append(" OFF\n");
			}
			System.out.print(sb);
		}
		br.close();
	}
}

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] heights;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			heights = new int[N];
			for (int idx = 0; idx < N; idx++) {
				heights[idx] = sc.nextInt();
			}

			int[] left = new int[N];
			for(int idx = 1; idx < N; idx++) {
				if(heights[idx -1] < heights[idx]) {
					left[idx] = left[idx -1] + 1;
				}
			}
			
			int[] right = new int[N];
			for(int idx = N - 2; idx >= 0; idx--) {
				if(heights[idx] > heights[idx + 1]) {
					right[idx] = right[idx + 1] + 1;
				}
			}
			
			int result = 0;
			for(int idx = 1; idx < N -1; idx++) {
				if(heights[idx -1] < heights[idx] && heights[idx] > heights[idx + 1]) {
					result += left[idx] * right[idx];
				}
			}
			

			bw.write("#" + testCase + " " + result + "\n");
		}

		sc.close();
		bw.flush();
		bw.close();
	}
}


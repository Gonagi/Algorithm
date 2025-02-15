import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			PriorityQueue<Integer> frontQue = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> backQue = new PriorityQueue<>();
			frontQue.add(A);
			int result = 0;
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				int cur = frontQue.peek();
								
				if (cur <= num1) {
					backQue.add(num1);
				} else {
					frontQue.add(num1);
				}

				if (cur <= num2) {
					backQue.add(num2);
				} else {
					frontQue.add(num2);
				}
				if (frontQue.size() > backQue.size() + 1) {
				    backQue.add(frontQue.poll());
				}
				if (frontQue.size() < backQue.size() + 1) {
				    frontQue.add(backQue.poll());
				}
				
				int middle = frontQue.peek();
				result = (result + middle) % 20171109;
			}
			bw.write(String.format("#%d %d", testCase, result));
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}
}

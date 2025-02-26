import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> fruits = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < N; idx++) {
			fruits.add(Integer.parseInt(st.nextToken()));
		}

		while (!fruits.isEmpty()) {
			int fruit = fruits.peek();
			if (fruit <= L) {
				fruits.poll();
				L++;
			} else {
				break;
			}
		}
		bw.write(L + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}


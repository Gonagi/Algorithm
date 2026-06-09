import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int count = (N - 1) / 2;

		PriorityQueue<Integer> leftQue = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
		PriorityQueue<Integer> rightQue = new PriorityQueue<>(); // 최소 힙

		int num = Integer.parseInt(br.readLine());

		leftQue.add(num);
		bw.write(String.valueOf(num));
		bw.newLine();

		for (int idx = 0; idx < count; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			addNumber(P, leftQue, rightQue);
			addNumber(Q, leftQue, rightQue);

			bw.write(String.valueOf(leftQue.peek()));
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static void addNumber(int num, PriorityQueue<Integer> leftQue, PriorityQueue<Integer> rightQue) {
		if (leftQue.isEmpty() || num <= leftQue.peek()) {
			leftQue.add(num);
		} else {
			rightQue.add(num);
		}

		if (leftQue.size() < rightQue.size() + 1) {
			leftQue.add(rightQue.poll());
		} else if (leftQue.size() > rightQue.size() + 1) {
			rightQue.add(leftQue.poll());
		}
	}
}


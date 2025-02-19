import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			boolean isInvalid = false;
			Deque<Character> stack = new ArrayDeque<>();
			for (int idx = 0; idx < N; idx++) {
				char cur = input.charAt(idx);
				if (isOpen(cur)) {
					stack.add(cur);
				} else {
					Character pop = stack.pollLast();
					if (pop == null || !isSame(pop, cur)) {
						isInvalid = true;
						break;
					}
				}
			}
			if (!stack.isEmpty() || isInvalid) {
				bw.write("#" + testCase + " " + 0 + "\n");
			} else {
				bw.write("#" + testCase + " " + 1 + "\n");
			}
		}
        bw.flush();
		br.close();
		bw.close();
	}

	static boolean isOpen(char c) {
		return c == '(' || c == '{' || c == '[' || c == '<';
	}

	static boolean isSame(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']')
				|| (c1 == '<' && c2 == '>');
	}
}

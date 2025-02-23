import java.io.*;
import java.util.*;

public class Main {
	static int S, P, result;
	static char[] input;
	static int[] check;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		input = br.readLine().toCharArray();
		check = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < 4; idx++) {
			check[idx] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[4];
		for (int idx = 0; idx < P; idx++) {
			int i = charToIndex(input[idx]);
			count[i]++;
		}

		result = 0;
		if (isValid(count, check)) {
			result++;
		}

		for (int idx = P; idx < S; idx++) {
			int addIdx = charToIndex(input[idx]);
			count[addIdx]++;
			int removeIdx = charToIndex(input[idx - P]);
			count[removeIdx]--;

			if (isValid(count, check)) {
				result++;
			}
		}

		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	private static int charToIndex(char ch) {
		switch (ch) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		default:
			return -1;
		}
	}

	private static boolean isValid(int[] current, int[] required) {
		for (int idx = 0; idx < 4; idx++) {
			if (current[idx] < required[idx]) {
				return false;
			}
		}
		return true;
	}
}

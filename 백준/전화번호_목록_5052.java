// 문자열
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static String[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= t; testCase++) {
			n = Integer.parseInt(br.readLine());
			numbers = new String[n];

			for (int idx = 0; idx < n; idx++) {
				numbers[idx] = br.readLine();
			}

			Arrays.sort(numbers);

			boolean check = true;
			for (int idx = 0; idx < n - 1; idx++) {
				if (numbers[idx + 1].startsWith(numbers[idx])) {
					bw.write("NO\n");
					check = false;
					break;
				}
			}
			if (check) {
				bw.write("YES\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}

// 트라이
import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		Map<Character, Node> childNode;
		boolean terminate;

		public Node() {
			this.childNode = new HashMap<>();
			this.terminate = false;
		}
	}

	static int n;
	static Node startNode;
	static boolean check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= t; testCase++) {
			n = Integer.parseInt(br.readLine());
			startNode = new Node();
			check = false;

			String[] inputs = new String[n];
			for (int idx = 0; idx < n; idx++) {
				inputs[idx] = br.readLine();
			}
			Arrays.sort(inputs);
			
			for (int idx = 0; idx < n && !check; idx++) {
				insert(inputs[idx], startNode);
			}

            if(check){
                bw.write("NO\n");
            }else{
                bw.write("YES\n");
            }
		}
		bw.flush();
		br.close();
		bw.close();
	}

	public static void insert(String word, Node curNode) {
		Node nextNode = curNode;
		int length = word.length();
		for (int idx = 0; idx < length && !check; idx++) {
			char curC = word.charAt(idx);
			nextNode.childNode.putIfAbsent(curC, new Node());
			nextNode = nextNode.childNode.get(curC);
			if (nextNode.terminate) {
				check = true;
				return;
			}
		}
		nextNode.terminate = true;
	}
}


import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int idx = 0; idx < N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int[] aCount = new int[5];
			for (int i = 0; i < a; i++) {
				aCount[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int[] bCount = new int[5];
			for (int i = 0; i < b; i++) {
				bCount[Integer.parseInt(st.nextToken())]++;
			}

			if (aCount[4] > bCount[4]) {
				bw.write("A\n");
			} else if (aCount[4] < bCount[4]) {
				bw.write("B\n");
			} else {
				if (aCount[3] > bCount[3]) {
					bw.write("A\n");
				} else if (aCount[3] < bCount[3]) {
					bw.write("B\n");
				} else {
					if (aCount[2] > bCount[2]) {
						bw.write("A\n");
					} else if (aCount[2] < bCount[2]) {
						bw.write("B\n");
					} else {
						if (aCount[1] > bCount[1]) {
							bw.write("A\n");
						} else if (aCount[1] < bCount[1]) {
							bw.write("B\n");
						} else {
							bw.write("D\n");
						}
					}
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

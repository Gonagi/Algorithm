import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < N; idx++) {
			weight[idx] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weight);

		long sum = 0;
		for (int idx = 0; idx < N; idx++) {
			if (weight[idx] > sum + 1) {
				break;
			}
			sum += weight[idx];
		}

		System.out.println(sum + 1);
		br.close();
	}
}


import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		arr[1] = 1;
		if (N > 1) {
			for (int num = 2; num <= N; num++) {
				int count = 0;
				for (int cur = 1; cur <= (int) Math.sqrt(num); cur++) {
					if (num % cur == 0) {
						count++;
					}
				}
				arr[num] = arr[num - 1] + count;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(arr[N]);
		System.out.println(sb);

		br.close();
	}
}

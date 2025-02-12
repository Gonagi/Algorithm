import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] length = new int[7];
		int koreaMelon = Integer.parseInt(br.readLine());

		int max1 = 0, max2 = 0, maxIdx1 = 0, maxIdx2 = 0;
		for (int idx = 1; idx <= 6; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			length[idx] = Integer.parseInt(st.nextToken());
			if (max1 < length[idx]) {
				maxIdx1 = idx;
				max1 = length[idx];
			}
		}
		int prevIdx = maxIdx1 - 1 < 1 ? 6 : maxIdx1 - 1;
		int nextIdx = maxIdx1 + 1 > 6 ? 1 : maxIdx1 + 1;
		maxIdx2 = length[prevIdx] > length[nextIdx] ? prevIdx : nextIdx;
		max2 = length[maxIdx2];

		int small1 = length[prevIdx] > length[nextIdx] ? length[prevIdx] - length[nextIdx]
				: length[nextIdx] - length[prevIdx];
		prevIdx = maxIdx2 - 1 < 1 ? 6 : maxIdx2 - 1;
		nextIdx = maxIdx2 + 1 > 6 ? 1 : maxIdx2 + 1;
		int small2 = length[prevIdx] > length[nextIdx] ? length[prevIdx] - length[nextIdx]
				: length[nextIdx] - length[prevIdx];

		int cal = max1 * max2 - small1 * small2;
		StringBuilder sb = new StringBuilder();
		sb.append(cal * koreaMelon);
		System.out.println(sb);
		br.close();
	}
}

import java.io.*;
import java.util.*;

public class Main {
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int width = 1, height = 1;

		for (int i = 2; i <= N; i++) {
			height = 2 * height + 1;
			width = 2 * width + 3;
		}

		arr = new char[height + 1][width + 1];
		for (char[] arrY : arr)
			Arrays.fill(arrY, ' ');

		if (N == 1) {
			bw.write('*');
		} else {
			if (N % 2 == 0) {
				fillStar(N, width / 2, width / 2, width / 2);
				for (int i = 0; i <= width / 2; i++) {
					bw.write(arr[i], 0, width - i + 1);
					bw.newLine();
				}
			} else {
				fillStar(N, 0, width / 2, width / 2 + 1);
				for (int i = 0; i <= width / 2; i++) {
					bw.write(arr[i], 0, width / 2 + i + 1);
					bw.newLine();
				}
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static void fillStar(int depth, int y, int x, int len) {
		if (len == 1) {
			arr[y][x] = '*';
			return;
		}

		if (depth % 2 == 0) {
			for (int i = 0; i < len; i++) {
				arr[y - i][x - i] = '*';
				arr[y - i][x + i] = '*';
			}
			for (int i = x - len; i <= x + len; i++) {
				arr[y - len][i] = '*';
			}
			fillStar(depth - 1, y - len + 1, x, len / 2);
		} else {
			for (int i = 0; i < len; i++) {
				arr[y + i][x - i] = '*';
				arr[y + i][x + i] = '*';
			}
			for (int i = x - len; i <= x + len; i++) {
				if (i < 0)
					continue;
				arr[y + len - 1][i] = '*';
			}
			fillStar(depth - 1, y + len - 2, x, len / 2 - 1);
		}
	}
}

import java.io.*;
import java.util.*;

public class Main {
	static int N, result = Integer.MIN_VALUE;
	static int[][] hits;
	static int[] fourths, arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		hits = new int[N][8];
		fourths = new int[N];
		arr = new int[8];
		for (int idx = 0; idx < 8; idx++) {
			arr[idx] = idx;
		}

		for (int idx = 0; idx < N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			fourths[idx] = Integer.parseInt(st.nextToken());
			for (int p = 0; p < 8; p++) {
				hits[idx][p] = Integer.parseInt(st.nextToken());
			}
		}

		do {
			int score = 0;
			int currentBatter = 0;

			for (int inning = 0; inning < N; inning++) {
				int outs = 0;
				int[] bases = new int[3];

				while (outs < 3) {
					int hit;
					if (currentBatter == 3) {
						hit = fourths[inning];
					} else {
						int playerIndex = (currentBatter < 3) ? arr[currentBatter] : arr[currentBatter - 1];
						hit = hits[inning][playerIndex];
					}
					switch (hit) {
					case 0:
						outs++;
						break;
					case 1:
						score += bases[2];
						bases[2] = bases[1];
						bases[1] = bases[0];
						bases[0] = 1;
						break;
					case 2:
						score += bases[2] + bases[1];
						bases[2] = bases[0];
						bases[1] = 1;
						bases[0] = 0;
						break;
					case 3:
						score += bases[2] + bases[1] + bases[0];
						bases[2] = 1;
						bases[1] = 0;
						bases[0] = 0;
						break;
					case 4:
						score += bases[2] + bases[1] + bases[0] + 1;
						bases[2] = bases[1] = bases[0] = 0;
						break;
					}
					currentBatter = (currentBatter + 1) % 9;
				}
			}
			result = Math.max(result, score);
		} while (np());

		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	private static boolean np() {
		int i = 7;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		int j = 7;
		while (arr[i - 1] >= arr[j]) {
			j--;
		}
		swap(i - 1, j);

		int k = 7;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}


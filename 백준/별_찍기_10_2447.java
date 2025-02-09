import java.io.*;

class Main {
	static int N;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		check(0, 0, N, false);

		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				sb.append(arr[y][x]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void check(int y, int x, int size, boolean isFive) {
		if(isFive) {
			for(int curY = 0; curY < size; curY++) {
				for(int curX = 0; curX < size; curX++) {
					arr[y + curY][x + curX] = ' ';
				}
			}
			return;
		}
		
		if(size == 1) {
			arr[y][x] = '*';
			return;
		}
		
		int nextSize = size / 3;
		int count = 0;
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				count++;
				check(y + r * nextSize, x +c * nextSize, nextSize, count == 5);
			}
		}
	}
}

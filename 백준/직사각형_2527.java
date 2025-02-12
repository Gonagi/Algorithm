import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int idx = 0; idx < 4; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());

			if (y1 > y4 || y2 < y3 || x1 > x4 || x2 < x3) {
				System.out.println('d');
			} else if ((x1 == x4 && y1 == y4) || (x2 == x3 && y1 == y4) || (x2 == x3 && y2 == y3)
					|| (x1 == x4 && y2 == y3)) {
				System.out.println('c');
			} else if ((x1 == x4 && !(y2 <= y3 || y1 >= y4)) || (x2 == x3 && !(y2 <= y3 || y1 >= y4))
					|| (y1 == y4 && !(x2 <= x3 || x4 <= x1)) || ((y2 == y3) && !(x2 <= x3 || x4 <= x1))) {
				System.out.println('b');
			} else {
				System.out.println('a');
			}
		}
		br.close();
	}
}

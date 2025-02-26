import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int quotient = N / 5;
		int remain = N % 5;
		int result = 0;

		while (true) {
			if (quotient < 0) {
				bw.write("-1" + "\n");
				break;
			}
			if (remain % 3 == 0) {
				result += quotient + remain / 3;
				bw.write(result + "\n");
				break;
			}

			quotient -= 1;
			remain += 5;
		}

		bw.flush();
		br.close();
		bw.close();
	}
}


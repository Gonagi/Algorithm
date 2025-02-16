import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] count = new int[7][2];

		for (int idx = 0; idx < N; idx++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			count[grade][sex]++;
		}

		int result = 0;
		for (int grade = 1; grade <= 6; grade++) {
			for (int sex = 0; sex < 2; sex++) {
				if (count[grade][sex] == 0) {
				continue;
				}
				if(count[grade][sex] % K == 0) {
					result += count[grade][sex] / K;
				}else {	
					result += count[grade][sex] / K + 1;
				}				
			}
		}

		System.out.println(result);
		br.close();
	}
}

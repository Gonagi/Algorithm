import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[10];
		
		for(int idx = 0; idx < 10; idx++) {
			num[idx] = Integer.parseInt(br.readLine().trim());
		}
		int sum = 0, result = 0;
		for(int n : num) {
			sum += n;
			if(sum >= 100) {
				if(Math.abs(sum - 100) <= Math.abs(result - 100)) {
					result = sum;
				}
			}else {
				if(Math.abs(sum - 100) < Math.abs(result - 100)) {
					result = sum;
				}
			}
				
			if(sum >100) {
				break;
			}
		}
		
		StringBuilder sb =new StringBuilder();
		sb.append(result);
		System.out.println(result);
		br.close();
	}
}

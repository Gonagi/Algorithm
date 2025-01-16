import java.io.*;
import java.util.*;

public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int[] cases;

    public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());

	    for (int testCase = 0; testCase < T; testCase++) {
		    sb = new StringBuilder(br.readLine().trim());
			int size = sb.length();
	        cases = Arrays.stream(br.readLine().trim().split(" "))
						  .mapToInt(Integer::parseInt).
						  toArray();

			for (int input : cases) {
				input %= size;
				if (input == 0) {
					continue;
				}
				if (input > 0) {
					change(input, size);
				} else {
					change(size + input, size);
				}
			}
			System.out.println(sb.toString());
		}
    }

    private static void change(final int input, final int size) {
		String frontString = sb.substring(input);
		String backString = sb.substring(0, input);
		sb.delete(0, size);
		sb.append(frontString).append(backString);
    }
}

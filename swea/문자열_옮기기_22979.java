import java.io.*;
import java.util.*;

public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String string;
    static int[] cases;

    public static void main(String[] args) throws Exception {
	    int T = Integer.parseInt(br.readLine().trim());
	
	    for (int testCase = 0; testCase < T; testCase++) {
	        string = br.readLine().trim();
	        int size = string.length();
	        int count = Integer.parseInt(br.readLine());
	        cases = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	
	        for (int input : cases) {
    			input %= size;
	        	if(input == 0) {
	        		continue;
	        	}
	        	if(input > 0) {
	        		string = change(input);
	        	}else {
	        		string = change(size + input);
	        	}
	        }
	        System.out.println(string);
	    }
    }

	private static String change(final int input) {
		String frontString = string.substring(input);
		String backString = string.substring(0, input);
		return frontString + backString;
	}
}

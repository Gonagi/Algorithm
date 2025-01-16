import java.io.*;
import java.util.*;
 
public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine().trim());
 
        for (int idx = 0; idx < T; idx++) {
            int[] heights = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(heights);
            int max = heights[heights.length - 1];
            int sum = Arrays.stream(heights).sum();
            System.out.println(max + 7 - (max + sum) % 7);
        }
    }
}

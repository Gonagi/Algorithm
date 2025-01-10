import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int B;
 
    public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= T; testCase++) {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        B = input[1];
        int[] H = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
 
        int result = findMinHeight(H, N);
        System.out.printf("#%d %d\n", testCase, result - B);
    }
    }
 
    private static int findMinHeight(final int[] H, final int N) {
    int result = Integer.MAX_VALUE;
    result = combination(H, 0, 0, result);
    return result;
    }
 
    private static int combination(final int[] H, int start, int sum, int result) {
    if (sum >= B) {
        return Math.min(result, sum);
    }
 
    for (int i = start; i < H.length; i++) {
        result = combination(H, i + 1, sum + H[i], result);
    }
 
    return result;
    }
}

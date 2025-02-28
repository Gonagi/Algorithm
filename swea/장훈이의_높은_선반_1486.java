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


/*
import java.io.*;
import java.util.*;
 
public class Solution {
    static int N, B, result;
    static int[] heights;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            result = Integer.MAX_VALUE;
            heights = new int[N];
 
            st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < N; idx++) {
                heights[idx] = Integer.parseInt(st.nextToken());
            }
 
            dfs(0, 0);
            bw.write("#" + testCase + " " + (result - B) + "\n");
        }
 
        bw.flush();
        br.close();
        bw.close();
    }
 
    static boolean dfs(int idx, int sum) {
        if (sum == B) {
            result = B;
            return true;
        }
 
        if (sum > B) {
            result = Math.min(result, sum);
            return false;
        }
 
        if (idx == N) {
            return false;
        }
        if (dfs(idx + 1, sum + heights[idx])) {
            return false;
        }
        if (dfs(idx + 1, sum)) {
            return false;
        }
 
        return false;
    }
}
*/

import java.io.*;
import java.util.*;
 
public class Solution {
    static int N, result;
    static int[][] map;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            result = 0;
            for (int y = 0; y < N; y++) {
                String mapX = br.readLine();
                for (int x = 0; x < N; x++) {
                    map[y][x] = Character.getNumericValue(mapX.charAt(x));
                }
            }
 
            int middle = N / 2;
            for (int y = 0; y < N; y++) {
                int offset = Math.abs(middle - y);
                for (int x = offset; x < N - offset; x++) {
                    result += map[y][x];
                }
            }
            bw.write("#" + testCase + " " + result + "\n");
        }
 
        bw.flush();
        br.close();
        bw.close();
    }
}


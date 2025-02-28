import java.io.*;
import java.util.*;
 
public class Solution {
    static int N, resultNumber, resultCount;
    static int[][] map, dp, directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            resultNumber = Integer.MAX_VALUE;
            resultCount = 0;
            map = new int[N][N];
            dp = new int[N][N];
 
            for (int y = 0; y < N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                    dp[y][x] = 1;
                }
            }
 
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    int cal = check(y, x);
                    if (resultCount < cal) {
                        resultCount = cal;
                        resultNumber = map[y][x];
                    }
                    if (resultCount == cal && resultNumber > map[y][x]) {
                        resultNumber = map[y][x];
                    }
                }
            }
 
            bw.write("#" + testCase + " " + resultNumber + " " + resultCount + "\n");
 
        }
        bw.flush();
        br.close();
        bw.close();
    }
 
    static int check(int y, int x) {
        if (dp[y][x] != 1) {
            return dp[y][x];
        }
 
        for (int[] d : directions) {
            int nextY = y + d[0];
            int nextX = x + d[1];
            if (!canMove(nextY, nextX) || map[nextY][nextX] != map[y][x] + 1) {
                continue;
            }
            dp[y][x] += check(nextY, nextX);
        }
        return dp[y][x];
    }
 
    static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}


import java.io.*;
import java.util.*;
 
public class Solution {
    static int N, L, result;
    static int[] scores, calories;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            scores = new int[N];
            calories = new int[N];
            result = 0;
            for (int idx = 0; idx < N; idx++) {
                st = new StringTokenizer(br.readLine());
                scores[idx] = Integer.parseInt(st.nextToken());
                calories[idx] = Integer.parseInt(st.nextToken());
            }
            solve(0, 0, 0);
            bw.write("#" + testCase + " " + result + "\n");
        }
 
        bw.flush();
        br.close();
        bw.close();
    }
 
    static void solve(int start, int totalScores, int totalCalories) {
        result = Math.max(result, totalScores);
 
        for (int idx = start; idx < N; idx++) {
            int nextScore = totalScores + scores[idx];
            int nextCalories = totalCalories + calories[idx];
            if (nextCalories > L) {
                continue;
            }
            solve(idx + 1, nextScore, nextCalories);
        }
    }
}


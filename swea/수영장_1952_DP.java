import java.io.*;
import java.util.*;
 
class Solution {
    static int N, day, month, threeMonth, year;
    static int[] days;
    static int[] dp;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            days = new int[12];
            dp = new int[12];
            StringTokenizer st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            threeMonth = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
 
            for (int idx = 0; idx < 12; idx++) {
                days[idx] = Integer.parseInt(st.nextToken());
            }
 
            dp[0] = Math.min(days[0] * day, month);
            dp[1] = dp[0] + Math.min(days[1] * day, month);
            dp[2] = Math.min(threeMonth, dp[1] + Math.min(days[2] * day, month));
 
            for (int idx = 3; idx < 12; idx++) {
                if (days[idx] == 0) {
                    dp[idx] = dp[idx - 1];
                }
                dp[idx] = Math.min(dp[idx - 3] + threeMonth, dp[idx - 1] + Math.min(days[idx] * day, month));
            }
            int result = Math.min(year, dp[11]);
            bw.write("#" + testCase + " " + result + "\n");
        }
 
        bw.flush();
        br.close();
        bw.close();
    }
}


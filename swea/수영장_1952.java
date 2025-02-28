import java.io.*;
import java.util.*;
 
public class Solution {
    static int result;
    static int[] days, charges;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            days = new int[12];
            charges = new int[4];
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < 4; idx++) {
                charges[idx] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < 12; idx++) {
                days[idx] = Integer.parseInt(st.nextToken());
            }
 
            result = Integer.MAX_VALUE;
            backTrack(11, 0);
            result = Math.min(result, charges[3]);
            bw.write("#" + testCase + " " + result + "\n");
        }
 
        bw.flush();
        br.close();
        bw.close();
    }
 
    static void backTrack(int curMonth, int sum) {
        if (result <= sum) {
            return;
        }
        if (curMonth < 0) {
            result = sum;
            return;
        }
 
        backTrack(curMonth - 3, sum + charges[2]);
        backTrack(curMonth - 1, sum + charges[1]);
        backTrack(curMonth - 1, sum + charges[0] * days[curMonth]);
    }
}


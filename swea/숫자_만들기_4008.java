import java.io.*;
import java.util.*;
 
public class Solution {
    static int N, max, min;
    static int[] operators, numbers;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            operators = new int[4];
            numbers = new int[N];
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < 4; idx++) {
                operators[idx] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < N; idx++) {
                numbers[idx] = Integer.parseInt(st.nextToken());
            }
 
            solve(0, numbers[0]);
            bw.write("#" + testCase + " " + (max - min) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
 
    static void solve(int count, int cal) {
        if (count == N - 1) {
            max = Math.max(max, cal);
            min = Math.min(min, cal);
            return;
        }
 
        if (operators[0] > 0) {
            operators[0]--;
            solve(count + 1, cal + numbers[count + 1]);
            operators[0]++;
        }
        if (operators[1] > 0) {
            operators[1]--;
            solve(count + 1, cal - numbers[count + 1]);
            operators[1]++;
        }
        if (operators[2] > 0) {
            operators[2]--;
            solve(count + 1, cal * numbers[count + 1]);
            operators[2]++;
        }
        if (operators[3] > 0) {
            operators[3]--;
            solve(count + 1, cal / numbers[count + 1]);
            operators[3]++;
        }
    }
}


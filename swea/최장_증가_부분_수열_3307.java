import java.io.*;
import java.util.*;

class Solution {
    static int[] A, LIS;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            A = new int[N];
            LIS = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < N; idx++) {
                A[idx] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for (int idx = 0; idx < N; idx++) {
                LIS[idx] = 1;
                for (int idx2 = 0; idx2 < idx; idx2++) {
                    if (A[idx2] < A[idx] && LIS[idx] < LIS[idx2] + 1) {
                        LIS[idx] = LIS[idx2] + 1;
                    }
                }
                max = Math.max(max, LIS[idx]);
            }

            bw.write("#" + testCase + " " + max + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


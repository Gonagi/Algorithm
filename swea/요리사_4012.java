import java.io.*;
import java.util.*;
 
public class Solution {
    static int N, result, totalFood;
    static int[][] S;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            result = Integer.MAX_VALUE;
 
            for (int y = 0; y < N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    S[y][x] = Integer.parseInt(st.nextToken());
                }
            }
 
            totalFood = (1 << N) - 1;
            solve(0, 0, 0);
            bw.write("#" + testCase + " " + result + "\n");
        }
 
        bw.flush();
        br.close();
        bw.close();
 
    }
 
    static void solve(int count, int start, int flag) {
        if (count == N / 2) {
            calculate(flag);
            return;
        }
        for (int idx = start; idx < N; idx++) {
            solve(count + 1, idx + 1, flag | (1 << idx));
        }
    }
 
    private static void calculate(int flag) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
 
        for (int idx = 0; idx < N; idx++) {
            if ((flag & (1 << idx)) != 0) {
                A.add(idx);
            }
        }
 
        int flag3 = totalFood ^ flag;
        for (int idx = 0; idx < N; idx++) {
            if ((flag3 & (1 << idx)) != 0) {
                B.add(idx);
            }
        }
 
        int aSum = 0, bSum = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                aSum += S[A.get(i)][A.get(j)] + S[A.get(j)][A.get(i)];
            }
        }
        for (int i = 0; i < B.size(); i++) {
            for (int j = i + 1; j < B.size(); j++) {
                bSum += S[B.get(i)][B.get(j)] + S[B.get(j)][B.get(i)];
            }
        }
 
        result = Math.min(result, Math.abs(aSum - bSum));
    }
}


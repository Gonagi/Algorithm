import java.io.*;
 
public class Solution {
    static long N, result;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Long.parseLong(br.readLine());
            result = 0;
            while (true) {
                if (N == 2) {
                    break;
                }
                long sqrtNum = (long) Math.sqrt(N);
                if (sqrtNum * sqrtNum == N) {
                    N = sqrtNum;
                } else {
                    result += (sqrtNum + 1) * (sqrtNum + 1) - N;
                    N = sqrtNum + 1;
                }
                result++;
            }
 
            bw.write("#" + testCase + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


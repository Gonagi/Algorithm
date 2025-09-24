import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input1 = br.readLine();
        String input2 = br.readLine();

        int length1 = input1.length();
        int length2 = input2.length();

        int[][] dp = new int[1002][1002];
        for (int idx = 0; idx < 1002; idx++) {
            Arrays.fill(dp[idx], 0);
        }

        for (int idx1 = 0; idx1 < length1; idx1++) {
            for (int idx2 = 0; idx2 < length2; idx2++) {
                if (input1.charAt(idx1) == input2.charAt(idx2)) {
                    dp[idx1 + 1][idx2 + 1] = dp[idx1][idx2] + 1;
                } else {
                    dp[idx1 + 1][idx2 + 1] = Math.max(dp[idx1][idx2 + 1], dp[idx1 + 1][idx2]);
                }
            }
        }

        bw.write(dp[length1][length2] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}


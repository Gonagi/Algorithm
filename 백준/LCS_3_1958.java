import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        String input3 = br.readLine();
        int length1 = input1.length();
        int length2 = input2.length();
        int length3 = input3.length();
        int[][][] dp = new int[101][101][101];

        for (int idx = 0; idx < length1; idx++) {
            for (int idx2 = 0; idx2 < length2; idx2++) {
                for (int idx3 = 0; idx3 < length3; idx3++) {
                    if (input1.charAt(idx) == input2.charAt(idx2) &&
                            input1.charAt(idx) == input3.charAt(idx3)) {
                        dp[idx + 1][idx2 + 1][idx3 + 1] = dp[idx][idx2][idx3] + 1;
                    } else {
                        dp[idx + 1][idx2 + 1][idx3 + 1] = Math.max(Math.max(
                                dp[idx][idx2 + 1][idx3 + 1],
                                dp[idx + 1][idx2][idx3 + 1]),
                                dp[idx + 1][idx2 + 1][idx3]);
                    }
                }
            }
        }

        System.out.println(dp[length1][length2][length3]);
        br.close();
    }
}


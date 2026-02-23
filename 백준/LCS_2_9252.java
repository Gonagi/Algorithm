import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        int length1 = input1.length();
        int length2 = input2.length();

        int[][] dp = new int[1001][1001];

        for (int idx = 0; idx < length1; idx++) {
            for (int idx2 = 0; idx2 < length2; idx2++) {
                if (input1.charAt(idx) == input2.charAt(idx2)) {
                    dp[idx + 1][idx2 + 1] = dp[idx][idx2] + 1;
                } else {
                    if (dp[idx][idx2 + 1] >= dp[idx + 1][idx2]) {
                        dp[idx + 1][idx2 + 1] = dp[idx][idx2 + 1];
                    } else {
                        dp[idx + 1][idx2 + 1] = dp[idx + 1][idx2];
                    }
                }
            }
        }

        System.out.println(dp[length1][length2]);

        if (dp[length1][length2] == 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        int i = length1;
        int j = length2;

        while (i > 0 && j > 0) {
            if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                sb.append(input1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println(sb.reverse());
        br.close();
    }
}


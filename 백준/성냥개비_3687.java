import java.io.*;
import java.util.*;

public class Main {
    static String[] dp;
    static String[] digit = {"1", "7", "4", "2", "0", "8"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        dp = new String[101];
        Arrays.fill(dp, null);

        dp[2] = "1";
        dp[3] = "7";
        dp[4] = "4";
        dp[5] = "2";
        dp[6] = "6";
        dp[7] = "8";

        for (int i = 8; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                if (dp[i - j] == null)
                    continue;

                String candidate = dp[i - j] + digit[j - 2];

                if (candidate.charAt(0) == '0')
                    continue;

                if (dp[i] == null || isSmaller(candidate, dp[i])) {
                    dp[i] = candidate;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 == 0) {
                bw.write(dp[n] + " " + findMax(n) + "\n");
            } else {
                bw.write(dp[n] + " 7" + findMax(n - 3) + "\n");
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }
    
    private static boolean isSmaller(String a, String b) {
        if (a.length() != b.length())
            return a.length() < b.length();
        return a.compareTo(b) < 0;
    }

    private static String findMax(int num) {
        String result = "";
        for (int idx = 0; idx < num / 2; idx++) {
            result += "1";
        }
        return result;
    }
}


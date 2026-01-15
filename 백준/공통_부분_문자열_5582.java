import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = str1.length();
        int m = str2.length();

        int[] dp = new int[m + 1];
        int max = 0;

        for (int idx = 0; idx < n; idx++) {
            for (int idx2 = m - 1; idx2 >= 0; idx2--) {
                if (str1.charAt(idx) == str2.charAt(idx2)) {
                    dp[idx2 + 1] = dp[idx2] + 1;
                    max = Math.max(max, dp[idx2 + 1]);
                } else {
                    dp[idx2 + 1] = 0;
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}


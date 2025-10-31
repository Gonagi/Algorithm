import java.io.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int size = input.length();
        int q = 1_000_000;

        int[] dp = new int[size + 1];

        if (input.charAt(0) == '0') {
            bw.write("0\n");
        } else {
            dp[0] = 1;
            dp[1] = 1;

            for (int idx = 2; idx <= size; idx++) {
                int front = input.charAt(idx - 2) - '0';
                int cur = input.charAt(idx - 1) - '0';

                if (cur != 0) {
                    dp[idx] = dp[idx - 1];
                }

                int num = front * 10 + cur;
                if (num >= 10 && num <= 26) {
                    dp[idx] = (dp[idx] + dp[idx - 2]) % q;
                }

                if (cur == 0 && (front != 1 && front != 2)) {
                    bw.write("0\n");
                    bw.flush();
                    br.close();
                    bw.close();
                    return;
                }
            }

            bw.write(dp[size] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


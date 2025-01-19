import java.io.*;

public class Main {
    static int height;
    static int[] stairs, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height = Integer.parseInt(br.readLine());
        stairs = new int[height + 1];
        dp = new int[height + 1];

        for (int idx = 1; idx <= height; idx++) {
            stairs[idx] = Integer.parseInt(br.readLine());
        }
        if (height == 1) {
            dp[1] = stairs[1];
        } else if (height == 2) {
            dp[2] = stairs[1] + stairs[2];
        } else {
            dp[1] = stairs[1];
            dp[2] = stairs[1] + stairs[2];
            dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

            for (int num = 4; num <= height; num++) {
                dp[num] = Math.max(dp[num - 3] + stairs[num - 1], dp[num - 2]) + stairs[num];
            }
        }
        System.out.println(dp[height]);
        br.close();
    }
}

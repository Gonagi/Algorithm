import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArr = br.readLine().toCharArray();
        br.close();

        int size = inputArr.length;
        int[] dp = new int[size];
        dp[0] = inputArr[0] == '0' ? 0 : 1;

        for (int idx = 1; idx < size; idx++) {
            if (inputArr[idx] != '0') {
                dp[idx] = dp[idx - 1];
            }

            if (canBind(inputArr[idx - 1], inputArr[idx])) {
                if (idx > 1) {
                    dp[idx] += dp[idx - 2];
                } else {
                    dp[idx]++;
                }
            }
        }

        System.out.println(dp[size - 1]);
    }

    private static boolean canBind(char c1, char c2) {
        if (c1 == '0') {
            return false;
        }

        int num = (c1 - '0') * 10 + (c2 - '0');

        if (10 <= num && num <= 34) {
            return true;
        }

        return false;
    }
}


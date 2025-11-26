import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] input = new int[N];
            int[] dp = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < N; idx++) {
                input[idx] = Integer.parseInt(st.nextToken());
                if (idx == 0) {
                    dp[0] = input[idx];
                } else {
                    dp[idx] = Math.max(input[idx], dp[idx - 1] + input[idx]);
                }
            }

            Arrays.sort(dp);
            bw.write(dp[N - 1] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


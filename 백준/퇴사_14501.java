import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 1];
        for (int day = 0; day < N; day++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[day] = Integer.parseInt(st.nextToken());
            P[day] = Integer.parseInt(st.nextToken());
        }

        for (int day = 0; day < N; day++) {
            if (day + T[day] <= N) {
                dp[day + T[day]] = Math.max(dp[day + T[day]], dp[day] + P[day]);
            }
            dp[day + 1] = Math.max(dp[day + 1], dp[day]);
        }
        System.out.println(dp[N]);
    }
}

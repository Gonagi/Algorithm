import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int t, p;

        public Node(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N + 1];
        long[] dp = new long[N + 2];
        for (int idx = 1; idx <= N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr[idx] = new Node(T, P);
        }

        for (int idx = 1; idx <= N; idx++) {
            dp[idx + 1] = Math.max(dp[idx], dp[idx + 1]);

            if (idx + arr[idx].t - 1 <= N) {
                dp[idx + arr[idx].t] = Math.max(dp[idx + arr[idx].t], dp[idx] + arr[idx].p);
            }
        }

        System.out.println(dp[N + 1]);
        br.close();
    }
}


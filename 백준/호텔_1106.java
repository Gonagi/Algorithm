import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int cost, count;

        public Node(int cost, int count) {
            this.cost = cost;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[N];
        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            arr[idx] = new Node(cost, count);
        }

        int[] dp = new int[C + 100];
        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;
        for (int cur = 1; cur < C + 100; cur++) {
            for (Node node : arr) {
                if (cur - node.count < 0) {
                    continue;
                }
                if (dp[cur] > dp[cur - node.count] + node.cost) {
                    dp[cur] = dp[cur - node.count] + node.cost;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int idx = C; idx < C + 100; idx++) {
            result = Math.min(result, dp[idx]);
        }

        System.out.println(result);
        br.close();
    }
}


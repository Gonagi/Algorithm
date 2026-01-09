import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static int[][] dp;
    static int[] parent;
    static int[] order;
    static int orderIdx = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < N - 1; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        dp = new int[N + 1][2];
        parent = new int[N + 1];
        order = new int[N];

        Arrays.fill(parent, -1);
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        parent[1] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            order[orderIdx++] = cur;

            for (int next : graph[cur]) {
                if (next == parent[cur]) {
                    continue;
                }
                if (parent[next] != -1) {
                    continue;
                }

                parent[next] = cur;
                que.add(next);
            }
        }

        dfs();
        bw.write(String.valueOf(Math.min(dp[1][0], dp[1][1])));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs() {
        for (int idx = orderIdx - 1; idx >= 0; idx--) {
            int cur = order[idx];

            dp[cur][1] = 1;
            dp[cur][0] = 0;

            for (int next : graph[cur]) {
                if (parent[next] == cur) {
                    dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
                    dp[cur][0] += dp[next][1];
                }
            }
        }
    }
}


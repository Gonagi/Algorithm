import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to, time;

        public Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static int N, M, X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<Node>[] ways = new ArrayList[N + 1];
        List<Node>[] reverseWays = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            ways[idx] = new ArrayList<>();
            reverseWays[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            ways[from].add(new Node(to, time));
            reverseWays[to].add(new Node(from, time));
        }

        int[] go = dijkstra(ways, X);
        int[] back = dijkstra(reverseWays, X);

        int result = 0;
        for (int idx = 1; idx <= N; idx++) {
            int sum = go[idx] + back[idx];

            if (sum > result) {
                result = sum;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static int[] dijkstra(List<Node>[] list, int start) {
        Queue<Node> que = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        int[] dp = new int[N + 1];

        que.add(new Node(start, 0));
        for (int idx = 1; idx <= N; idx++) {
            dp[idx] = 987654321;
        }
        dp[start] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (check[cur.to]) {
                continue;
            }
            check[cur.to] = true;

            for (Node next : list[cur.to]) {
                if (dp[cur.to] != 987654321 && dp[cur.to] + next.time < dp[next.to]) {
                    dp[next.to] = dp[cur.to] + next.time;
                    que.add(new Node(next.to, dp[next.to]));
                }
            }
        }

        return dp;
    }
}


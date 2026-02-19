import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int city;
        long distance;

        public Node(int city, long distance) {
            this.city = city;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Node>[] graph = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[V].add(new Node(U, C));
        }

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Node> que = new PriorityQueue<>();
        long[] dp = new long[N + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < K; idx++) {
            int k = Integer.parseInt(st.nextToken());
            que.add(new Node(k, 0));
            dp[k] = 0;
        }

        int num = 0;
        long max = 0;
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            if (curNode.distance > dp[curNode.city]) {
                continue;
            }
            if (max < curNode.distance) {
                num = curNode.city;
                max = curNode.distance;
            } else if (max == curNode.distance) {
                if (num > curNode.city) {
                    num = curNode.city;
                }
            }
            for (Node nextNode : graph[curNode.city]) {
                if (dp[nextNode.city] > curNode.distance + nextNode.distance) {
                    dp[nextNode.city] = curNode.distance + nextNode.distance;
                    que.add(new Node(nextNode.city, curNode.distance + nextNode.distance));
                }
            }
        }

        sb.append(num).append('\n').append(max);
        System.out.println(sb);
        br.close();
    }
}


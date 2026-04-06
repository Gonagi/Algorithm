import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < N - 1; idx++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph[node1].add(new Node(node2, distance));
            graph[node2].add(new Node(node1, distance));
        }

        int[] parent = new int[N + 1];
        int[] depth = new int[N + 1];
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        visited[1] = true;
        depth[1] = 0;
        dist[1] = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();

            for (Node nextNode : graph[cur]) {
                if (!visited[nextNode.to]) {
                    visited[nextNode.to] = true;
                    parent[nextNode.to] = cur;
                    depth[nextNode.to] = depth[cur] + 1;
                    dist[nextNode.to] = dist[cur] + nextNode.value;
                    que.add(nextNode.to);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int u = node1;
            int v = node2;

            while (depth[u] > depth[v]) {
                u = parent[u];
            }

            while (depth[v] > depth[u]) {
                v = parent[v];
            }

            while (u != v) {
                u = parent[u];
                v = parent[v];
            }

            int result = dist[node1] + dist[node2] - 2 * dist[u];
            sb.append(result).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}


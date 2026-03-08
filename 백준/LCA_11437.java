import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < N - 1; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        int[] depth = new int[N + 1];
        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        visited[1] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;
                    parent[next] = cur;
                    que.add(next);
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < M; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            while (depth[node1] > depth[node2]) {
                node1 = parent[node1];
            }
            while (depth[node1] < depth[node2]) {
                node2 = parent[node2];
            }
            while (node1 != node2) {
                node1 = parent[node1];
                node2 = parent[node2];
            }
            sb.append(node1).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}


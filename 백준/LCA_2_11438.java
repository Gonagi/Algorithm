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

        int LOG = 17;
        int[][] parent = new int[LOG][N + 1];
        int[] depth = new int[N + 1];
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
                    parent[0][next] = cur;
                    que.add(next);
                }
            }
        }

        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= N; v++) {
                parent[k][v] = parent[k - 1][parent[k - 1][v]];
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < M; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (depth[node1] < depth[node2]) {
                int tmp = node1;
                node1 = node2;
                node2 = tmp;
            }

            for (int k = LOG - 1; k >= 0; k--) {
                if (depth[node1] - depth[node2] >= (1 << k)) {
                    node1 = parent[k][node1];
                }
            }

            if (node1 != node2) {
                for (int k = LOG - 1; k >= 0; k--) {
                    if (parent[k][node1] != parent[k][node2]) {
                        node1 = parent[k][node1];
                        node2 = parent[k][node2];
                    }
                }
                node1 = parent[0][node1];
            }

            sb.append(node1).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}


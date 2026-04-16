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

    static List<Node>[] graph;
    static int N, M, from, to;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        int left = 1, right = 1_000_000_000;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (bfs(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static boolean bfs(int limit) {
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        que.add(from);
        visited[from] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == to) {
                return true;
            }
            for (Node nextNode : graph[cur]) {
                if (!visited[nextNode.to] && nextNode.value >= limit) {
                    visited[nextNode.to] = true;
                    que.add(nextNode.to);
                }
            }
        }
        return false;
    }
}


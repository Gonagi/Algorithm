import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int cur, depth;

        public Node(int cur, int depth) {
            this.cur = cur;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < m; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(1, 0));
        visited[1] = true;
        int count = 0;
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            for (int next : graph[curNode.cur]) {
                if (!visited[next] && curNode.depth <= 1) {
                    visited[next] = true;
                    count++;
                    que.add(new Node(next, curNode.depth + 1));
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}


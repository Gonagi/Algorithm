import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        long length;

        public Node(int end, long length) {
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.length, o.length);
        }
    }

    static int V, E, K;
    static List<Node>[] graphs;
    static long[] length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graphs = new ArrayList[V + 1];
        for (int idx = 1; idx <= V; idx++) {
            graphs[idx] = new ArrayList<>();
        }

        length = new long[V + 1];
        Arrays.fill(length, Long.MAX_VALUE);

        for (int idx = 0; idx < E; idx++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graphs[u].add(new Node(v, w));
        }

        dijkstra();

        for (int idx = 1; idx <= V; idx++) {
            if (length[idx] == Long.MAX_VALUE) {
                bw.write("INF\n");
                continue;
            }
            bw.write(length[idx] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        que.offer(new Node(K, 0));
        length[K] = 0;

        while (!que.isEmpty()) {
            Node curNode = que.poll();

            if (visited[curNode.end]) {
                continue;
            }

            visited[curNode.end] = true;
            for (Node nextNode : graphs[curNode.end]) {
                if (length[nextNode.end] > length[curNode.end] + nextNode.length) {
                    length[nextNode.end] = length[curNode.end] + nextNode.length;
                    que.add(new Node(nextNode.end, length[nextNode.end]));
                }
            }
        }

    }
}


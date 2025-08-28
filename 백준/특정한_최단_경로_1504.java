import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        long weight;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    static class State implements Comparable<State> {
        int v;
        long dist;

        State(int v, long dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    static int N;
    static List<Node>[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);

        graphs = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graphs[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < E; idx++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graphs[a].add(new Node(b, c));
            graphs[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long distance1 = 0;
        distance1 += dijkstra(1, v1);
        distance1 += dijkstra(v1, v2);
        distance1 += dijkstra(v2, N);

        long distance2 = 0;
        distance2 += dijkstra(1, v2);
        distance2 += dijkstra(v2, v1);
        distance2 += dijkstra(v1, N);

        long result = (distance1 >= 200_000_000 && distance2 >= 200_000_000) ? -1 : Math.min(distance1, distance2);

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();

    }

    private static long dijkstra(int start, int end) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, 200_000_000);
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new State(start, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist != dist[cur.v])
                continue; // stale

            for (Node e : graphs[cur.v]) {
                long nd = cur.dist + e.weight;
                if (nd < dist[e.end]) {
                    dist[e.end] = nd;
                    pq.add(new State(e.end, nd));
                }
            }
        }
        return dist[end];
    }

}


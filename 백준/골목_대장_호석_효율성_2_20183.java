import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        long value;

        public Node(int to, long value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.value, o.value);
        }
    }

    static int N, M, A, B;
    static List<Node>[] graph;
    static long C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }

        int right = -1;
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            graph[from].add(new Node(to, value));
            graph[to].add(new Node(from, value));
            right = Math.max(right, (int) value);
        }

        int left = 0, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canGo(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static boolean canGo(int max) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(A, 0));
        dist[A] = 0;

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            if (curNode.value > C) {
                continue;
            }
            if (curNode.value > dist[curNode.to]) {
                continue;
            }

            for (Node nextNode : graph[curNode.to]) {
                if (nextNode.value > max) {
                    continue;
                }
                if (curNode.value + nextNode.value > C) {
                    continue;
                }

                if (dist[nextNode.to] > curNode.value + nextNode.value) {
                    dist[nextNode.to] = curNode.value + nextNode.value;
                    que.add(new Node(nextNode.to, dist[nextNode.to]));
                }
            }
        }

        return dist[B] <= C;
    }
}


import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to, value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.value, this.value);
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

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        br.close();

        int[] dist = new int[N + 1];
        dist[from] = Integer.MAX_VALUE;
        
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(from, dist[from]));
        while (!que.isEmpty()) {
            Node curNode = que.poll();

            if (curNode.to == to) {
                System.out.println(curNode.value);
                return;
            }

            for (Node nextNode : graph[curNode.to]) {
                int nextWeight = Math.min(curNode.value, nextNode.value);
                if (dist[nextNode.to] < nextWeight) {
                    dist[nextNode.to] = nextWeight;
                    que.add(new Node(nextNode.to, nextWeight));
                }
            }
        }
    }
}


import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int cur, count;

        public Node(int cur, int count) {
            this.cur = cur;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(N, 0));

        while (!que.isEmpty()) {
            Node node = que.poll();

            if (visited[node.cur]) {
                continue;
            }
            visited[node.cur] = true;

            if (node.cur == K) {
                bw.write(node.count + "\n");
                break;
            }

            int next = 2 * node.cur;
            if (next <= 100_000 && !visited[next]) {
                que.add(new Node(next, node.count));
            }

                        next = node.cur + 1;
            if (next <= 100_000 && !visited[next]) {
                que.add(new Node(next, node.count + 1));
            }
            
            next = node.cur - 1;
            if (0 <= next && !visited[next]) {
                que.add(new Node(next, node.count + 1));
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


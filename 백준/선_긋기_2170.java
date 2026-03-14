import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int from, to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {
            if (this.from == o.from) {
                return Integer.compare(this.to, o.to);
            }
            return Integer.compare(this.from, o.from);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> que = new PriorityQueue<>();
        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            que.add(new Node(x, y));
        }

        Node firstNode = que.poll();
        int start = firstNode.from;
        int end = firstNode.to;
        int result = end - start;
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            if (end < curNode.from) {
                start = curNode.from;
                end = curNode.to;
                result += Math.abs(end - start);
            } else if (curNode.to > end) {
                result += Math.abs(curNode.to - end);
                end = curNode.to;
            }
        }

        System.out.println(result);
        br.close();
    }
}


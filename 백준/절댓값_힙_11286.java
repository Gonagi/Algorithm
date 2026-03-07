import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int num, distance;

        public Node(int num) {
            this.num = num;
            this.distance = Math.abs(num);
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance == o.distance) {
                return Integer.compare(this.num, o.num);
            }
            return Integer.compare(this.distance, o.distance);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pQue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < N; idx++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pQue.add(new Node(x));
            } else {
                if (pQue.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    Node node = pQue.poll();
                    sb.append(node.num).append('\n');
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}


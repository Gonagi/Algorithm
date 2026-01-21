import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int d, w;

        public Node(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.d, o.d);
        }
    }

    static class Node2 implements Comparable<Node2> {
        int d, w;

        public Node2(Node node) {
            this.d = node.d;
            this.w = node.w;
        }

        @Override
        public int compareTo(Node2 o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[idx] = new Node(d, w);
        }

        Arrays.sort(arr);
        PriorityQueue<Node2> pQue = new PriorityQueue<>();
        for (Node node : arr) {
            pQue.add(new Node2(node));

            if (pQue.size() > node.d) {
                pQue.poll();
            }
        }

        int answer = 0;
        for (Node2 node2 : pQue) {
            answer += node2.w;
        }
        System.out.println(answer);
        br.close();
    }
}


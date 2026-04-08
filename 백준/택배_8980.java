import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int from, to, count;

        public Node(int from, int to, int count) {
            this.from = from;
            this.to = to;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.to == o.to) {
                return Integer.compare(this.from, o.from);
            }
            return Integer.compare(this.to, o.to);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        Node[] house = new Node[M];
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            house[idx] = new Node(from, to, count);
        }

        Arrays.sort(house);

        int[] delivery = new int[N + 1];
        int result = 0;
        for (Node curNode : house) {
            int max = 0;
            for (int idx = curNode.from; idx < curNode.to; idx++) {
                max = Math.max(max, delivery[idx]);
            }

            int canLoad = Math.min(curNode.count, C - max);
            for (int idx = curNode.from; idx < curNode.to; idx++) {
                delivery[idx] += canLoad;
            }

            result += canLoad;
        }

        System.out.println(result);
        br.close();
    }
}


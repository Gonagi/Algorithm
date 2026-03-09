import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int from, to, value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Node> que = new ArrayDeque<>();
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            que.add(new Node(A, B, C));
        }
        br.close();

        long[] distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        for (int idx = 1; idx < N; idx++) {
            for (Node curNode : que) {
                if (distance[curNode.from] == Integer.MAX_VALUE) {
                    continue;
                }
                if (distance[curNode.to] > distance[curNode.from] + curNode.value) {
                    distance[curNode.to] = distance[curNode.from] + curNode.value;
                }
            }
        }

        for (Node curNode : que) {
            if (distance[curNode.from] == Integer.MAX_VALUE) {
                continue;
            }
            if (distance[curNode.to] > distance[curNode.from] + curNode.value) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int idx = 2; idx <= N; idx++) {
            sb.append(distance[idx] == Integer.MAX_VALUE ? -1 : distance[idx]).append('\n');
        }
        System.out.println(sb);
    }
}


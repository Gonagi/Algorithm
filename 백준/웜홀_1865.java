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
        int TC = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            Queue<Node> que = new ArrayDeque<>();

            for (int idx = 0; idx < M; idx++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                que.add(new Node(S, E, T));
                que.add(new Node(E, S, T));
            }
            for (int idx = 0; idx < W; idx++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                que.add(new Node(S, E, -1 * T));
            }

            long[] distance = new long[N + 1];
            Arrays.fill(distance, 0);
            boolean hasCycle = false;
            for (int idx = 1; idx <= N; idx++) {
                for (Node curNode : que) {
                    if (distance[curNode.to] > distance[curNode.from] + curNode.value) {
                        distance[curNode.to] = distance[curNode.from] + curNode.value;
                        if (idx == N) {
                            hasCycle = true;
                            break;
                        }
                    }
                }
            }
            sb.append(hasCycle ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
        br.close();
    }
}


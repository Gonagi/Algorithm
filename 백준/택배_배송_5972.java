import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int location, count;

        public Node(int location, int count) {
            this.location = location;
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
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];

        List<Node>[] map = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            map[idx] = new ArrayList<>();
            dp[idx] = Integer.MAX_VALUE;
        }

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            map[A].add(new Node(B, C));
            map[B].add(new Node(A, C));
        }

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(1, 0));
        dp[1] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int curLocation = cur.location;
            int curCount = cur.count;

            if (curLocation == N) {
                bw.write(curCount + "\n");
                break;
            }

            for (Node next : map[curLocation]) {
                int nextLocation = next.location;
                int nextCount = curCount + next.count;

                if (nextCount >= dp[nextLocation]) {
                    continue;
                }

                dp[nextLocation] = nextCount;
                que.add(new Node(nextLocation, nextCount));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


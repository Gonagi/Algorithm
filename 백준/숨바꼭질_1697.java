import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int cur, count;

        public Node(int cur, int count) {
            this.cur = cur;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(N, 0));
        visited[N] = true;

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            int cur = curNode.cur;
            int count = curNode.count;
            visited[cur] = true;

            if (cur == K) {
                bw.write(count + "\n");
                break;
            }

            int[] nextPositions = {cur * 2, cur - 1, cur + 1};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    que.add(new Node(next, count + 1));
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


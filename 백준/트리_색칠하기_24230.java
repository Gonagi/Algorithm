import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int cur, parent;

        public Node(int cur, int parent) {
            this.cur = cur;
            this.parent = parent;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] colors = new int[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            colors[idx] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] tree = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            tree[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < N - 1; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tree[from].add(to);
            tree[to].add(from);
        }

        int count = 0;
        Deque<Node> que = new ArrayDeque<>();
        que.add(new Node(1, 0));

        while (!que.isEmpty()) {
            Node curNode = que.pollFirst();
            if (colors[curNode.cur] != 0 && colors[curNode.cur] != colors[curNode.parent]) {
                count++;
            }

            for (int next : tree[curNode.cur]) {
                if (next == curNode.parent) {
                    continue;
                }
                que.addLast(new Node(next, curNode.cur));
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }
}


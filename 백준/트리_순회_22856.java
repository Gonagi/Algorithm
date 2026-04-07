import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static int[] depth;
    static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            nodes[cur] = new Node(left, right);
        }

        int cur = 1;
        while (nodes[cur].right != -1) {
            cur = nodes[cur].right;
        }
        depth = new int[N + 1];
        dfs(1, 0);

        int result = 2 * (N - 1) - depth[cur];
        System.out.println(result);
        br.close();
    }

    private static void dfs(int cur, int curDepth) {
        depth[cur] = curDepth;

        if (nodes[cur].left != -1) {
            dfs(nodes[cur].left, curDepth + 1);
        }

        if (nodes[cur].right != -1) {
            dfs(nodes[cur].right, curDepth + 1);
        }
    }
}


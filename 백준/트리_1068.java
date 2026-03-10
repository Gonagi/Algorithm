import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] tree;
    static int delete, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for (int idx = 0; idx < N; idx++) {
            tree[idx] = new ArrayList<>();
        }
        int[] parent = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int idx = 0; idx < N; idx++) {
            parent[idx] = Integer.parseInt(st.nextToken());
            if (parent[idx] == -1) {
                root = idx;
            } else {
                tree[parent[idx]].add(idx);
            }
        }

        delete = Integer.parseInt(br.readLine());
        br.close();

        if (delete == root) {
            System.out.println(0);
            return;
        }
        Queue<Integer> que = new ArrayDeque<>();
        que.add(delete);
        parent[delete] = -1;
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : tree[cur]) {
                if (parent[next] != -1) {
                    parent[next] = -1;
                    que.add(next);
                }
            }
        }

        dfs(root);
        System.out.println(result);
    }

    private static void dfs(int cur) {
        int childCount = 0;
        for (int next : tree[cur]) {
            if (next == delete) {
                continue;
            }
            childCount++;
            dfs(next);
        }

        if (childCount == 0) {
            result++;
        }
    }
}


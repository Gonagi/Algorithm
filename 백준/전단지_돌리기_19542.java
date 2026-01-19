import java.io.*;
import java.util.*;

public class Main {
    static int N, S, D, count;
    static int[] depth;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < N - 1; idx++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        depth = new int[N + 1];

        dfs(S, -1);
        System.out.println(count * 2);
        br.close();
    }

    private static int dfs(int cur, int parent) {
        for (int next : graph[cur]) {
            if (next == parent) {
                continue;
            }
            depth[cur] = Math.max(depth[cur], dfs(next, cur) + 1);
        }

        if (cur != S && depth[cur] >= D) {
            count++;
        }
        return depth[cur];
    }
}


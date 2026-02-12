import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] visited;
    static List<Integer>[] graph;
    static boolean hasCycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1;; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            graph = new ArrayList[n + 1];
            for (int idx = 1; idx <= n; idx++) {
                graph[idx] = new ArrayList<>();
            }

            for (int idx = 0; idx < m; idx++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                graph[to].add(from);
            }

            visited = new boolean[n + 1];
            int result = 0;
            for (int cur = 1; cur <= n; cur++) {
                if (!visited[cur]) {
                    hasCycle = false;
                    dfs(cur, -1);
                    if (!hasCycle) {
                        result++;
                    }
                }
            }

            sb.append("Case ").append(testCase).append(": ");
            if (result > 1) {
                sb.append("A forest of ").append(result).append(" trees.\n");
            } else if (result == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("No trees.\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int cur, int parent) {
        visited[cur] = true;
        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next, cur);
            } else if (next != parent) {
                hasCycle = true;
            }
        }
    }
}


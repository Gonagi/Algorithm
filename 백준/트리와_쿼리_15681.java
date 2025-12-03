import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int parent;
        List<Integer> children;

        public Node(int parent) {
            this.parent = parent;
            children = new ArrayList<>();
        }
    }

    static List<Integer>[] graph;
    static int[] size;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        size = new int[N + 1];
        visited = new boolean[N + 1];

        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < N - 1; idx++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[U].add(V);
            graph[V].add(U);
        }

        dfs(R);

        for (int idx = 0; idx < Q; idx++) {
            int U = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(size[U]));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        size[cur] = 1;

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);
                size[cur] += size[next];
            }
        }
    }
}


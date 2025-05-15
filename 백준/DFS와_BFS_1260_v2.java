import java.io.*;
import java.util.*;

class Main {
    static int N, M, V;
    static boolean[][] lines;
    static boolean[] visited;
    static boolean check = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        lines = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            lines[node1][node2] = true;
            lines[node2][node1] = true;
        }
        DFS(V, bw);
        bw.newLine();
        visited = new boolean[N + 1];
        BFS(bw);

        bw.flush();
        br.close();
        bw.close();
    }

    static void DFS(int cur, BufferedWriter bw) throws Exception {
        visited[cur] = true;
        bw.write(cur + " ");
        for (int next = 1; next <= N; next++) {
            if (lines[cur][next] && !visited[next]) {
                DFS(next, bw);
            }
        }
    }

    static void BFS(BufferedWriter bw) throws Exception {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(V);

        while (!que.isEmpty()) {
            int cur = que.poll();
            visited[cur] = true;
            bw.write(cur + " ");

            for (int next = 1; next <= N; next++) {
                if (lines[cur][next] && !visited[next]) {
                    que.add(next);
                    visited[next] = true;
                }
            }
        }

    }
}


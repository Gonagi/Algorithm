import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static boolean[] visited;
    static int N, M, V;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            matrix[y][x] = 1;
            matrix[x][y] = 1;
        }
        dfs(V);
        sb.append("\n");
        bfs();
        System.out.println(sb);
        
        br.close();
        bw.close();
    }

    static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(" ");

        for (int next = 1; next <= N; next++) {
            if (visited[next]) {
                continue;
            }
            if (matrix[cur][next] == 1) {
                dfs(next);
            }
        }
    }

    static void bfs() {
        visited = new boolean[N + 1];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(V);
        visited[V] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            sb.append(cur).append(" ");
            for (int next = 1; next <= N; next++) {
                if (visited[next]) {
                    continue;
                }
                if (matrix[cur][next] == 1) {
                    que.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}

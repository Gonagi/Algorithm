import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count;
        N = Integer.parseInt(br.readLine());
        count = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][N + 1];
        for (int idx = 0; idx < count; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }

        int result = bfs();
        System.out.println(result);

        br.close();
    }

    private static int bfs() {
        int result = 0;
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        visited[1] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            visited[cur] = true;
            result++;

            for (int next = 1; next <= N; next++) {
                if (visited[next]) {
                    continue;
                }
                if (matrix[cur][next] == 1) {
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
        return result - 1;
    }
}

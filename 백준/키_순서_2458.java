import java.io.*;
import java.util.*;

class Main {
    static int N, M, smallCount, tallCount, result;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;
        map = new boolean[N + 1][N + 1];

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }

        for (int cur = 1; cur <= N; cur++) {
            smallCount = 0;
            tallCount = 0;
            smallDFS(cur, new boolean[N + 1]);
            tallDFS(cur, new boolean[N + 1]);

            if (smallCount + tallCount == N - 1) {
                result++;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void smallDFS(int cur, boolean[] visited) {
        visited[cur] = true;
        for (int next = 1; next <= N; next++) {
            if (!visited[next] && map[cur][next]) {
                smallCount++;
                smallDFS(next, visited);
            }
        }
    }

    private static void tallDFS(int cur, boolean[] visited) {
        visited[cur] = true;
        for (int next = 1; next <= N; next++) {
            if (!visited[next] && map[next][cur]) {
                tallCount++;
                tallDFS(next, visited);
            }
        }
    }
}


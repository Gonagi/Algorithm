import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] p = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < M; idx++) {
            p[idx] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Queue<Integer> que = new ArrayDeque<>();

        for (int idx = 0; idx < M; idx++) {
            visited[p[idx]] = true;
            dist[p[idx]] = 0;
            que.add(p[idx]);
        }

        int max = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int bit = 0; bit < 20; bit++) {
                int next = cur ^ (1 << bit);

                if (next < 0 || next > N || visited[next]) {
                    continue;
                }

                visited[next] = true;
                dist[next] = dist[cur] + 1;
                max = Math.max(max, dist[next]);
                que.add(next);
            }
        }

        System.out.println(max);
        br.close();
    }
}


import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        int[] plan = new int[M];

        StringTokenizer st;
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    map[y][x] = true;
                    map[x][y] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < M; idx++) {
            plan[idx] = Integer.parseInt(st.nextToken()) - 1;
        }

        if (isPlanPossible(plan)) {
            bw.write("YES\n");
        } else {
            bw.write("NO\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean isPlanPossible(int[] plan) {
        for (int idx = 0; idx < M - 1; idx++) {
            if (!isConnected(plan[idx], plan[idx + 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isConnected(int cur, int goal) {
        boolean[] visited = new boolean[N];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(cur);
        visited[cur] = true;

        while (!que.isEmpty()) {
            int curNode = que.poll();
            if (curNode == goal) {
                return true;
            }

            for (int nextNode = 0; nextNode < N; nextNode++) {
                if (map[curNode][nextNode] && !visited[nextNode]) {
                    visited[nextNode] = true;
                    que.add(nextNode);
                }
            }
        }
        return false;
    }
}


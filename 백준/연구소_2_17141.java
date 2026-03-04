import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M, min = Integer.MAX_VALUE;
    static List<Node> virusList;
    static int virusSize;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        virusList = new ArrayList<>();

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) {
                    virusList.add(new Node(y, x));
                }
            }
        }
        virusSize = virusList.size();
        visited = new boolean[virusSize];

        dfs(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        br.close();
    }

    private static void bfs() {
        boolean[][] check = new boolean[N][N];
        Queue<Node> que = new ArrayDeque<>();
        for (int idx = 0; idx < virusSize; idx++) {
            if (visited[idx]) {
                Node node = virusList.get(idx);
                que.add(node);
                check[node.y][node.x] = true;
            }
        }

        int count = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (check[y][x] || map[y][x] == 1) {
                    count++;
                }
            }
        }

        if (count == N * N) {
            min = Math.min(min, 0);
            return;
        }

        int time = 0;
        while (!que.isEmpty()) {
            if (time >= min) {
                return;
            }
            int curSize = que.size();
            for (int q = 0; q < curSize; q++) {
                Node curNode = que.poll();

                for (int[] dir : directions) {
                    int nextY = curNode.y + dir[0];
                    int nextX = curNode.x + dir[1];
                    if (canMove(nextY, nextX) && map[nextY][nextX] != 1 &&
                            !check[nextY][nextX]) {
                        check[nextY][nextX] = true;
                        que.add(new Node(nextY, nextX));
                    }
                }
            }
            time++;
        }
        count = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (check[y][x] || map[y][x] == 1) {
                    count++;
                }
            }
        }

        if (count == N * N) {
            min = Math.min(min, time - 1);
            return;
        }
    }

    private static void dfs(int cur, int count) {
        if (count == M) {
            bfs();
            return;
        }
        for (int next = cur; next < virusSize; next++) {
            visited[next] = true;
            dfs(next + 1, count + 1);
            visited[next] = false;
        }
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}


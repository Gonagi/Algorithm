import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x, wall, count;

        public Node(int y, int x, int wall, int count) {
            this.y = y;
            this.x = x;
            this.wall = wall;
            this.count = count;
        }
    }

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[2][N + 1][M + 1];

        for (int y = 1; y <= N; y++) {
            String inputX = br.readLine();
            for (int x = 1; x <= M; x++) {
                map[y][x] = inputX.charAt(x - 1) - '0';
            }
        }

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(1, 1, 0, 1));
        visited[0][1][1] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.y == N && cur.x == M) {
                bw.write(cur.count + "\n");
                bw.flush();
                br.close();
                bw.close();
                return;
            }
            for (int[] dir : DIRECTIONS) {
                int nextY = cur.y + dir[0];
                int nextX = cur.x + dir[1];
                if (!canMove(nextY, nextX)) {
                    continue;
                }

                if (map[cur.y][cur.x] == 0) {
                    if (!visited[cur.wall][nextY][nextX]) {
                        visited[cur.wall][nextY][nextX] = true;
                        que.add(new Node(nextY, nextX, cur.wall, cur.count + 1));
                    }
                } else {
                    if (!visited[1][nextY][nextX] && cur.wall == 0) {
                        visited[1][nextY][nextX] = true;
                        que.add(new Node(nextY, nextX, 1, cur.count + 1));
                    }
                }
            }
        }

        bw.write(-1 + "\n");
        bw.flush();
        br.close();
        bw.close();

    }

    private static boolean canMove(int y, int x) {
        return y >= 1 && x >= 1 && y <= N && x <= M;
    }
}


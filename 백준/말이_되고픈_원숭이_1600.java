import java.io.*;
import java.util.*;

class Main {
    static final int[][] DIRECTIONS1 = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static final int[][] DIRECTIONS2 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Direction {
        int y, x, count;

        public Direction(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    static int K, W, H;
    static boolean[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new boolean[H][W];
        visited = new boolean[H][W][K + 1];

        for (int y = 0; y < H; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < W; x++) {
                if (st.nextToken().equals("1")) {
                    map[y][x] = false;
                } else {
                    map[y][x] = true;
                }
            }
        }

        Queue<Direction> que = new ArrayDeque<>();
        que.add(new Direction(0, 0, 0));
        visited[0][0][0] = true;

        bw.write(BFS(que) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int BFS(Queue<Direction> que) {
        int time = 0;
        while (!que.isEmpty()) {
            int size = que.size();

            for (int s = 0; s < size; s++) {
                Direction cur = que.poll();
                if (cur.y == H - 1 && cur.x == W - 1) {
                    return time;
                }
                if (cur.count < K) {
                    for (int[] d : DIRECTIONS1) {
                        int nextY = cur.y + d[0];
                        int nextX = cur.x + d[1];
                        if (canMove(nextY, nextX) && !visited[nextY][nextX][cur.count + 1] && map[nextY][nextX]) {
                            que.add(new Direction(nextY, nextX, cur.count + 1));
                            visited[nextY][nextX][cur.count + 1] = true;
                        }
                    }
                }
                for (int[] d : DIRECTIONS2) {
                    int nextY = cur.y + d[0];
                    int nextX = cur.x + d[1];
                    if (canMove(nextY, nextX) && !visited[nextY][nextX][cur.count] && map[nextY][nextX]) {
                        que.add(new Direction(nextY, nextX, cur.count));
                        visited[nextY][nextX][cur.count] = true;
                    }
                }
            }

            time++;
        }
        return -1;
    }

    static boolean canMove(int y, int x) {
        return 0 <= y && y < H && 0 <= x && x < W;
    }
}


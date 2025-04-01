import java.io.*;
import java.util.*;

class Main {
    static class Direction {
        int y, x;

        public Direction(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M, result = 0;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Direction> que;
    static java.util.List<Direction> empty;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        que = new ArrayDeque<>();
        empty = new ArrayList<>();

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) {
                    que.add(new Direction(y, x));
                } else if (map[y][x] == 0) {
                    empty.add(new Direction(y, x));
                }
            }
        }
        DFS(0, 0, new Direction[3]);

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void DFS(int start, int count, Direction[] arr) {
        if (count == 3) {
            result = Math.max(result, cal());
            return;
        }

        for (int idx = start; idx < empty.size(); idx++) {
            arr[count] = empty.get(idx);
            int y = arr[count].y;
            int x = arr[count].x;
            map[y][x] = 1;
            DFS(idx + 1, count + 1, arr);
            map[y][x] = 0;
        }
    }

    static int cal() {
        int[][] copyMap = new int[N][M];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                copyMap[y][x] = map[y][x];
            }
        }

        Queue<Direction> que2 = new ArrayDeque<>();
        for (Direction d : que) {
            que2.add(new Direction(d.y, d.x));
        }

        while (!que2.isEmpty()) {
            Direction cur = que2.poll();
            int curY = cur.y;
            int curX = cur.x;
            for (int[] d : directions) {
                int nextY = curY + d[0];
                int nextX = curX + d[1];

                if (canMove(nextY, nextX) && copyMap[nextY][nextX] == 0) {
                    copyMap[nextY][nextX] = 2;
                    que2.add(new Direction(nextY, nextX));
                }
            }
        }

        int safe = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (copyMap[y][x] == 0) {
                    safe++;
                }
            }
        }
        return safe;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}


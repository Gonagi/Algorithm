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

    static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int[][] upDir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static final int[][] downDir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static Node up, down;
    static int R, C, T;
    static int[][] map, nextMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        nextMap = new int[R][C];

        Queue<Node> que = new ArrayDeque<>();
        boolean foundUp = false;

        for (int y = 0; y < R; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < C; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());

                if (map[y][x] == -1) {
                    if (!foundUp) {
                        up = new Node(y, x);
                        foundUp = true;
                    } else {
                        down = new Node(y, x);
                    }
                }

                if (map[y][x] > 0)
                    que.add(new Node(y, x));
            }
        }

        while (T-- > 0) {

            spreadDust(que);
            applySpread();

            circulate(up, upDir);
            circulate(down, downDir);

            refillQueue(que);
        }

        System.out.println(sumDust());
    }

    static void spreadDust(Queue<Node> que) {
        while (!que.isEmpty()) {
            Node cur = que.poll();
            int curDust = map[cur.y][cur.x];

            if (curDust < 5)
                continue;

            int spreadAmount = curDust / 5;
            int cnt = 0;

            for (int[] d : directions) {
                int ny = cur.y + d[0];
                int nx = cur.x + d[1];

                if (inRange(ny, nx) && !isCleaner(ny, nx)) {
                    nextMap[ny][nx] += spreadAmount;
                    cnt++;
                }
            }

            map[cur.y][cur.x] -= spreadAmount * cnt;
        }
    }

    static void applySpread() {
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] != -1)
                    map[y][x] += nextMap[y][x];
                nextMap[y][x] = 0;
            }
        }
    }

    static void circulate(Node cleaner, int[][] dirSet) {
        int cy = cleaner.y;
        int cx = cleaner.x;

        int dir = 0;
        int curY = cy, curX = cx;

        while (true) {
            int ny = curY + dirSet[dir][0];
            int nx = curX + dirSet[dir][1];

            if (ny == cy && nx == cx)
                break;

            if (!inRange(ny, nx)) {
                dir = (dir + 1) % 4;
                continue;
            }
            if (dir == 2 && curY == cy) {
                dir = (dir + 1) % 4;
                continue;
            }

            if (map[curY][curX] != -1) {
                map[curY][curX] = map[ny][nx];
            }

            curY = ny;
            curX = nx;
        }

        map[cy][cx + 1] = 0;
    }

    static void refillQueue(Queue<Node> que) {
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] > 0)
                    que.add(new Node(y, x));
            }
        }
    }

    static boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }

    static boolean isCleaner(int y, int x) {
        return (y == up.y && x == up.x) || (y == down.y && x == down.x);
    }

    static int sumDust() {
        int sum = 0;
        for (int y = 0; y < R; y++)
            for (int x = 0; x < C; x++)
                if (map[y][x] > 0)
                    sum += map[y][x];
        return sum;
    }
}


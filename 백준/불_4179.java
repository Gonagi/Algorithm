import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x, time;

        Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int R, C;
    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static boolean[][] visited;
    static Queue<Node> fireQue = new ArrayDeque<>();
    static Queue<Node> jQue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int y = 0; y < R; y++) {
            String line = br.readLine();
            for (int x = 0; x < C; x++) {
                map[y][x] = line.charAt(x);
                if (map[y][x] == 'F') {
                    fireQue.offer(new Node(y, x, 0));
                } else if (map[y][x] == 'J') {
                    jQue.offer(new Node(y, x, 0));
                    visited[y][x] = true;

                    if (isEdge(y, x)) {
                        bw.write("1\n");
                        bw.flush();
                        return;
                    }
                }
            }
        }

        while (!jQue.isEmpty()) {
            spreadFire();

            int size = jQue.size();
            for (int i = 0; i < size; i++) {
                Node cur = jQue.poll();

                for (int[] dir : DIRECTIONS) {
                    int ny = cur.y + dir[0];
                    int nx = cur.x + dir[1];
                    int nextTime = cur.time + 1;

                    if (!inRange(ny, nx))
                        continue;
                    if (map[ny][nx] != '.' || visited[ny][nx])
                        continue;

                    if (isEdge(ny, nx)) {
                        bw.write((nextTime + 1) + "\n");
                        bw.flush();
                        return;
                    }

                    visited[ny][nx] = true;
                    jQue.offer(new Node(ny, nx, nextTime));
                }
            }
        }

        bw.write("IMPOSSIBLE\n");
        bw.flush();
    }

    static void spreadFire() {
        int size = fireQue.size();
        for (int i = 0; i < size; i++) {
            Node cur = fireQue.poll();

            for (int[] dir : DIRECTIONS) {
                int ny = cur.y + dir[0];
                int nx = cur.x + dir[1];

                if (!inRange(ny, nx))
                    continue;
                if (map[ny][nx] == '.' || map[ny][nx] == 'J') {
                    map[ny][nx] = 'F';
                    fireQue.offer(new Node(ny, nx, cur.time + 1));
                }
            }
        }
    }

    static boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }

    static boolean isEdge(int y, int x) {
        return y == 0 || y == R - 1 || x == 0 || x == C - 1;
    }
}


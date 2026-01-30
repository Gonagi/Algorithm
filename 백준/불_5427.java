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

    static int w, h;
    static boolean isExist;
    static char[][] map;
    static Queue<Node> fireQue, sangunQue;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fireQue = new ArrayDeque<>();
            sangunQue = new ArrayDeque<>();
            isExist = false;

            for (int y = 0; y < h; y++) {
                String line = br.readLine();
                for (int x = 0; x < w; x++) {
                    map[y][x] = line.charAt(x);
                    if (map[y][x] == '@') {
                        sangunQue.add(new Node(y, x));
                        if (y == 0 || y == h - 1 || x == 0 || x == w - 1) {
                            isExist = true;
                        }
                    } else if (map[y][x] == '*') {
                        fireQue.add(new Node(y, x));
                    }
                }
            }

            int time = 1;
            if (!isExist) {
                while (!sangunQue.isEmpty()) {
                    time++;
                    fireBfs();
                    if (sangunBfs()) {
                        isExist = true;
                        break;
                    }
                }
            }

            if (isExist) {
                sb.append(time).append('\n');
            } else {
                sb.append("IMPOSSIBLE\n");
            }
        }

        System.out.println(sb);
    }

    private static void fireBfs() {
        int size = fireQue.size();
        for (int idx = 0; idx < size; idx++) {
            Node cur = fireQue.poll();
            for (int[] d : directions) {
                int ny = cur.y + d[0];
                int nx = cur.x + d[1];
                if (canMove(ny, nx) && map[ny][nx] != '#' && map[ny][nx] != '*') {
                    map[ny][nx] = '*';
                    fireQue.add(new Node(ny, nx));
                }
            }
        }
    }

    private static boolean sangunBfs() {
        int size = sangunQue.size();
        for (int idx = 0; idx < size; idx++) {
            Node cur = sangunQue.poll();
            for (int[] d : directions) {
                int ny = cur.y + d[0];
                int nx = cur.x + d[1];

                if (!canMove(ny, nx)) {
                    continue;
                }
                if (map[ny][nx] != '.') {
                    continue;
                }

                if (ny == 0 || ny == h - 1 || nx == 0 || nx == w - 1) {
                    return true;
                }

                map[ny][nx] = '@';
                sangunQue.add(new Node(ny, nx));
            }
        }
        return false;
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}


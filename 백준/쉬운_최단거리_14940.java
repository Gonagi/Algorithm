import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int y, x, distance;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map, result;
    static boolean[][] visited;
    static int startY, startX, n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            Arrays.fill(result[y], -1);
        }

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) {
                    startY = y;
                    startX = x;
                } else if (map[y][x] == 0) {
                    result[y][x] = 0;
                }
            }
        }

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(startY, startX));
        result[startY][startX] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int curY = cur.y;
            int curX = cur.x;
            visited[curY][curX] = true;

            for (int[] d : DIRECTIONS) {
                int nextY = curY + d[0];
                int nextX = curX + d[1];

                if (canMove(nextY, nextX)) {
                    if (map[nextY][nextX] == 0) {
                        result[nextY][nextX] = 0;
                    } else if (!visited[nextY][nextX] && map[nextY][nextX] == 1) {
                        result[nextY][nextX] = result[curY][curX] + 1;
                        visited[nextY][nextX] = true;
                        que.add(new Node(nextY, nextX));
                    }
                }
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                bw.write(result[y][x] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}


import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int y, x, count, key;

        public Node(int y, int x, int count, int key) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.key = key;
        }
    }

    static int N, M;
    static char[][] map;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[64][N][M];

        int startY = 0, startX = 0;
        for (int y = 0; y < N; y++) {
            String mapX = br.readLine().trim();
            for (int x = 0; x < M; x++) {
                map[y][x] = mapX.charAt(x);
                if (map[y][x] == '0') {
                    startY = y;
                    startX = x;
                    map[y][x] = '.';
                }
            }
        }

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(startY, startX, 0, 0));
        visited[0][startY][startX] = true;
        int result = -1;
        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (map[cur.y][cur.x] == '1') {
                result = cur.count;
                break;
            }

            for (int[] dir : directions) {
                int nextY = cur.y + dir[0];
                int nextX = cur.x + dir[1];
                int nextKey = cur.key;
                if (!canMove(nextY, nextX) || visited[cur.key][nextY][nextX] || map[nextY][nextX] == '#') {
                    continue;
                }
                if (map[nextY][nextX] == '.' || map[nextY][nextX] == '0') {
                    visited[cur.key][nextY][nextX] = true;
                    que.add(new Node(nextY, nextX, cur.count + 1, cur.key));
                } else if (isKeys(map[nextY][nextX])) {
                    nextKey |= (1 << (map[nextY][nextX] - 'a'));

                } else if (isDoor(map[nextY][nextX])) {
                    if ((nextKey & (1 << (map[nextY][nextX] - 'A'))) == 0) {
                        continue;
                    }
                }
                if (!visited[nextKey][nextY][nextX]) {
                    visited[nextKey][nextY][nextX] = true;
                    que.add(new Node(nextY, nextX, cur.count + 1, nextKey));
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static boolean isKeys(char cur) {
        if ('a' <= cur && cur <= 'f') {
            return true;
        }
        return false;
    }

    static boolean isDoor(char cur) {
        if ('A' <= cur && cur <= 'F') {
            return true;
        }
        return false;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}


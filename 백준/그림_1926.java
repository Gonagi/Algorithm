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

    static int n, m, count, max;
    static int[][] map;
    static boolean[][] visitedMap;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visitedMap = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                check(y, x);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n').append(max);
        System.out.println(sb);
        br.close();
    }

    private static void check(int y, int x) {
        if (visitedMap[y][x] || map[y][x] == 0) {
            return;
        }

        count++;
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(y, x));
        int extent = 0;
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            visitedMap[curNode.y][curNode.x] = true;
            extent++;

            for (int[] dir : directions) {
                int nextY = curNode.y + dir[0];
                int nextX = curNode.x + dir[1];
                if (canMove(nextY, nextX) && map[nextY][nextX] == 1 && !visitedMap[nextY][nextX]) {
                    visitedMap[nextY][nextX] = true;
                    que.add(new Node(nextY, nextX));
                }
            }
        }
        max = Math.max(max, extent);
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}


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

    static int h, w, time, size;
    static boolean[][] outerMap;
    static char[][] map;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        outerMap = new boolean[h][w];

        for (int y = 0; y < h; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < w; x++) {
                map[y][x] = st.nextToken().charAt(0);
            }
        }

        while (!isDone()) {
            outerMap = new boolean[h][w];
            findOxygen();
            findOuterCheese();
            time++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time).append('\n').append(size);
        System.out.println(sb);

        br.close();
    }

    private static void findOxygen() {
        Queue<Node> outerQue = new ArrayDeque<>();
        for (int y = 0; y < h; y++) {
            outerQue.add(new Node(y, 0));
            outerQue.add(new Node(y, w - 1));
            outerMap[y][0] = true;
            outerMap[y][w - 1] = true;
        }
        for (int x = 0; x < w; x++) {
            outerQue.add(new Node(0, x));
            outerQue.add(new Node(h - 1, x));
            outerMap[0][x] = true;
            outerMap[h - 1][x] = true;
        }

        while (!outerQue.isEmpty()) {
            Node curNode = outerQue.poll();
            for (int[] dir : directions) {
                int nextY = curNode.y + dir[0];
                int nextX = curNode.x + dir[1];
                if (canMove(nextY, nextX) && map[nextY][nextX] == '0'
                        && !outerMap[nextY][nextX]) {
                    outerMap[nextY][nextX] = true;
                    outerQue.add(new Node(nextY, nextX));
                }
            }
        }
    }

    private static boolean isDone() {
        int curSize = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (map[y][x] == '1') {
                    curSize++;
                }
            }
        }
        if (curSize == 0) {
            return true;
        }
        size = curSize;
        return false;
    }

    private static void findOuterCheese() {
        Queue<Node> que = new ArrayDeque<>();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (map[y][x] == '1') {
                    for (int[] dir : directions) {
                        int nextY = y + dir[0];
                        int nextX = x + dir[1];
                        if (canMove(nextY, nextX) && outerMap[nextY][nextX]) {
                            que.add(new Node(y, x));
                            break;
                        }
                    }
                }
            }
        }

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            map[curNode.y][curNode.x] = '0';
        }
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}


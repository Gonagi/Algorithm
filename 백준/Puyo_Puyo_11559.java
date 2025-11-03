= input.charAt(x);
            }
        }

        while (true) {
            visited = new boolean[12][6];
            boolean check = false;

            for (int y = 0; y < 12; y++) {
                for (int x = 0; x < 6; x++) {
                    if (map[y][x] != '.' && !visited[y][x]) {
                        check = BFS(y, x, check);
                    }
                }
            }

            if (!check) {
                break;
            }

            // 중력
            moveDown();

            count++;
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();

    }

    private static boolean BFS(int y, int x, boolean check) {
        List<Node> list = new ArrayList<>();
        Queue<Node> qimport java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static char[][] map;
    static boolean[][] visited;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[12][6];
        int count = 0;

        for (int y = 0; y < 12; y++) {
            String input = br.readLine();
            for (int x = 0; x < 6; x++) {
                map[y][x] ue = new ArrayDeque<>();
        char curChar = map[y][x];
        que.add(new Node(y, x));
        visited[y][x] = true;

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            list.add(curNode);

            for (int[] direction : directions) {
                int nextY = curNode.y + direction[0];
                int nextX = curNode.x + direction[1];

                if (canMove(nextY, nextX) &&
                        !visited[nextY][nextX] &&
                        map[nextY][nextX] == curChar) {
                    visited[nextY][nextX] = true;
                    que.add(new Node(nextY, nextX));
                }
            }
        }

        if (list.size() >= 4) {
            for (Node node : list) {
                map[node.y][node.x] = '.';
            }
            check = true;
        }

        return check;
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y <= 11 && x >= 0 && x <= 5;
    }

    private static void moveDown() {
        for (int x = 0; x < 6; x++) {
            for (int y = 11; y >= 0; y--) {
                if (map[y][x] == '.') {
                    continue;
                }
                int nextY = y;

                while (nextY + 1 < 12 && map[nextY + 1][x] == '.') {
                    map[nextY + 1][x] = map[nextY][x];
                    map[nextY][x] = '.';
                    nextY++;
                }
            }
        }
    }
}


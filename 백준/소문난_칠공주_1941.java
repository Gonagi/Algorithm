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

    static char[][] map;
    static boolean[][] visitedMap, recordMap;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] selected;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        recordMap = new boolean[5][5];
        selected = new int[8];

        for (int y = 0; y < 5; y++) {
            String inputX = br.readLine();
            for (int x = 0; x < 5; x++) {
                map[y][x] = inputX.charAt(x);
            }
        }

        dfs(0, 0);

        System.out.println(count);
        br.close();
    }

    private static void dfs(int start, int depth) {
        if (depth == 7) {
            boolean[][] chosen = new boolean[5][5];
            int sCount = 0;
            for (int idx = 0; idx < 7; idx++) {
                int y = selected[idx] / 5;
                int x = selected[idx] % 5;
                chosen[y][x] = true;
                if (map[y][x] == 'S') {
                    sCount++;
                }
            }
            if (sCount < 4) {
                return;
            }

            Queue<Node> que = new ArrayDeque<>();
            boolean[][] visited = new boolean[5][5];
            que.add(new Node(selected[0] / 5, selected[0] % 5));
            visited[selected[0] / 5][selected[0] % 5] = true;

            int check = 1;
            while (!que.isEmpty()) {
                Node curNode = que.poll();

                for (int[] dir : directions) {
                    int nextY = curNode.y + dir[0];
                    int nextX = curNode.x + dir[1];
                    if (canMove(nextY, nextX) && !visited[nextY][nextX] &&
                            chosen[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        check++;
                        que.add(new Node(nextY, nextX));
                    }
                }
            }
            if (check == 7) {
                count++;
            }
            return;
        }

        for (int idx = start; idx < 25; idx++) {
            selected[depth] = idx;
            dfs(idx, depth + 1);
        }
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < 5 && x >= 0 && x < 5;
    }
}


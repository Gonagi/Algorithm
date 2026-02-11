import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int z, y, x;

        public Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static int[][][] map;
    static int[][][][] rotatedMap;
    static int[][][] curMap;
    static int[][] directions = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
    static int[] order;
    static boolean[] visited;
    static int[] rotationChoice;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5][5];
        rotatedMap = new int[5][4][5][5];
        for (int z = 0; z < 5; z++) {
            for (int y = 0; y < 5; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < 5; x++) {
                    map[z][y][x] = Integer.parseInt(st.nextToken());
                    rotatedMap[z][0][y][x] = map[z][y][x];
                }
            }

            for (int k = 1; k < 4; k++) {
                for (int y = 0; y < 5; y++) {
                    for (int x = 0; x < 5; x++) {
                        rotatedMap[z][k][y][x] = rotatedMap[z][k - 1][4 - x][y];
                    }
                }
            }
        }
        order = new int[5];
        visited = new boolean[5];
        curMap = new int[5][5][5];
        rotationChoice = new int[5];
        dfs(0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min - 1);

        br.close();
    }

    private static void dfs(int depth) {
        if (min == 13) {
            return;
        }
        if (depth == 5) {
            rotationDfs(0);
            return;
        }

        for (int idx = 0; idx < 5; idx++) {
            if (!visited[idx]) {
                visited[idx] = true;
                order[depth] = idx;
                dfs(depth + 1);
                visited[idx] = false;
            }
        }
    }

    private static void rotationDfs(int depth) {
        if (min == 13) {
            return;
        }

        if (depth == 5) {
            for (int z = 0; z < 5; z++) {
                for (int y = 0; y < 5; y++) {
                    for (int x = 0; x < 5; x++) {
                        curMap[z][y][x] = rotatedMap[order[z]][rotationChoice[z]][y][x];
                    }
                }
            }
            if (curMap[0][0][0] == 0 || curMap[4][4][4] == 0) {
                return;
            }
            bfs();
            return;
        }

        for (int idx = 0; idx < 4; idx++) {
            rotationChoice[depth] = idx;
            rotationDfs(depth + 1);
        }
    }

    private static void bfs() {
        int[][][] countMap = new int[5][5][5];
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(0, 0, 0));
        countMap[0][0][0] = 1;

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            if (curNode.z == 4 && curNode.y == 4 && curNode.x == 4) {
                min = Math.min(min, countMap[curNode.z][curNode.y][curNode.x]);
                break;
            }
            if (min <= countMap[curNode.z][curNode.y][curNode.x]) {
                break;
            }

            for (int[] dir : directions) {
                int nextZ = curNode.z + dir[0];
                int nextY = curNode.y + dir[1];
                int nextX = curNode.x + dir[2];
                if (canMove(nextZ, nextY, nextX) && curMap[nextZ][nextY][nextX] == 1 &&
                        countMap[nextZ][nextY][nextX] == 0) {
                    countMap[nextZ][nextY][nextX] = countMap[curNode.z][curNode.y][curNode.x] + 1;
                    que.add(new Node(nextZ, nextY, nextX));
                }
            }
        }
    }

    private static boolean canMove(int z, int y, int x) {
        return z >= 0 && z < 5 && y >= 0 && y < 5 && x >= 0 && x < 5;
    }
}


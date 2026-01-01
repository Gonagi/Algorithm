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

    static int Y, X, maxDistance;
    static Character[][] map;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new Character[Y][X];

        for (int y = 0; y < Y; y++) {
            String inputX = br.readLine();
            for (int x = 0; x < X; x++) {
                map[y][x] = inputX.charAt(x);
            }
        }

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (map[y][x] == 'W') {
                    continue;
                } else {
                    bfs(y, x);
                }
            }
        }

        bw.write(String.valueOf(maxDistance));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int y, int x) {
        int[][] distance = new int[Y][X];
        for (int y2 = 0; y2 < Y; y2++) {
            Arrays.fill(distance[y2], -1);
        }
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(y, x));
        distance[y][x] = 0;

        while (!que.isEmpty()) {
            Node curNode = que.poll();

            for (int[] dir : directions) {
                int nextY = curNode.y + dir[0];
                int nextX = curNode.x + dir[1];
                if (canMove(nextY, nextX) && distance[nextY][nextX] == -1 && map[nextY][nextX] == 'L') {
                    que.add(new Node(nextY, nextX));
                    distance[nextY][nextX] = distance[curNode.y][curNode.x] + 1;
                    maxDistance = Math.max(maxDistance, distance[nextY][nextX]);
                }
            }
        }
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < Y && x >= 0 && x < X;
    }
}


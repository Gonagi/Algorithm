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

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M;
    static List<Node>[][] map;
    static boolean[][] visitedMap;
    static boolean[][] lightMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1][N + 1];
        visitedMap = new boolean[N + 1][N + 1];
        lightMap = new boolean[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                map[y][x] = new ArrayList<>();
            }
        }

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[x][y].add(new Node(a, b));
        }

        int count = 1;
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(1, 1));
        visitedMap[1][1] = true;
        lightMap[1][1] = true;

        while (!que.isEmpty()) {
            Node curNode = que.poll();

            for (Node nextNode : map[curNode.y][curNode.x]) {
                if (!lightMap[nextNode.y][nextNode.x]) {
                    lightMap[nextNode.y][nextNode.x] = true;
                    count++;
                    for (int[] dir : directions) {
                        int nextY = nextNode.y + dir[0];
                        int nextX = nextNode.x + dir[1];
                        if (canMove(nextY, nextX) && visitedMap[nextY][nextX]) {
                            visitedMap[nextNode.y][nextNode.x] = true;
                            que.add(nextNode);
                            break;
                        }
                    }
                }
            }

            for (int[] dir : directions) {
                int nextY = curNode.y + dir[0];
                int nextX = curNode.x + dir[1];
                if (canMove(nextY, nextX) && lightMap[nextY][nextX] &&
                        !visitedMap[nextY][nextX]) {
                    visitedMap[nextY][nextX] = true;
                    que.add(new Node(nextY, nextX));
                }
            }
        }

        System.out.println(count);
        br.close();

    }

    private static boolean canMove(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= N;
    }
}


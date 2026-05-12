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

    static int[][] map;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int M, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Queue<Node> que = new ArrayDeque<>();
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1) {
                    que.add(new Node(y, x));
                }
            }
        }
        br.close();

        int time = 0;
        while (!que.isEmpty()) {
            int qSize = que.size();
            for (int q = 0; q < qSize; q++) {
                Node curNode = que.poll();
                for (int[] dir : directions) {
                    int nextY = curNode.y + dir[0];
                    int nextX = curNode.x + dir[1];
                    if (canMove(nextY, nextX) && map[nextY][nextX] == 0) {
                        map[nextY][nextX] = 1;
                        que.add(new Node(nextY, nextX));
                    }
                }
            }
            time++;
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(time - 1);
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}


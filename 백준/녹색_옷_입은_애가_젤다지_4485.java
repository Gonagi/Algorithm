import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int y, x, value;

        public Node(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int testCase = 1;; testCase++) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int[][] map = new int[N][N], dp = new int[N][N];
            for (int y = 0; y < N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                    dp[y][x] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> que = new PriorityQueue<>();
            que.add(new Node(0, 0, map[0][0]));
            dp[0][0] = map[0][0];

            while (!que.isEmpty()) {
                Node cur = que.poll();

                if (cur.y == N - 1 && cur.x == N - 1) {
                    bw.write("Problem " + testCase + ": " + cur.value + "\n");
                    break;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextY = cur.y + dir[0];
                    int nextX = cur.x + dir[1];

                    if (canMove(nextY, nextX)) {
                        int nextValue = cur.value + map[nextY][nextX];
                        if (dp[nextY][nextX] > nextValue) {
                            dp[nextY][nextX] = nextValue;
                            que.add(new Node(nextY, nextX, nextValue));
                        }
                    }
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}


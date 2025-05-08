import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int y, x, d, sum;

        public Node(int y, int x, int d, int sum) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.sum = sum;
        }
    }

    static int N, M, result = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < M; x++) {
            for (int d = 0; d < 3; d++) {
                BFS(x, d);
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void BFS(int x, int d) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(0, x, d, map[0][x]));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.y == N - 1) {
                result = Math.min(result, cur.sum);
            } else {
                if (cur.d == 0) {
                    if (canMove(cur.y + 1, cur.x)) {
                        que.add(new Node(cur.y + 1, cur.x, 1, cur.sum + map[cur.y + 1][cur.x]));
                    }
                    if (canMove(cur.y + 1, cur.x + 1)) {
                        que.add(new Node(cur.y + 1, cur.x + 1, 2, cur.sum + map[cur.y + 1][cur.x + 1]));
                    }
                } else if (cur.d == 1) {
                    if (canMove(cur.y + 1, cur.x - 1)) {
                        que.add(new Node(cur.y + 1, cur.x - 1, 0, cur.sum + map[cur.y + 1][cur.x - 1]));
                    }
                    if (canMove(cur.y + 1, cur.x + 1)) {
                        que.add(new Node(cur.y + 1, cur.x + 1, 2, cur.sum + map[cur.y + 1][cur.x + 1]));
                    }
                } else if (cur.d == 2) {
                    if (canMove(cur.y + 1, cur.x - 1)) {
                        que.add(new Node(cur.y + 1, cur.x - 1, 0, cur.sum + map[cur.y + 1][cur.x - 1]));
                    }
                    if (canMove(cur.y + 1, cur.x)) {
                        que.add(new Node(cur.y + 1, cur.x, 1, cur.sum + map[cur.y + 1][cur.x]));
                    }
                }
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}


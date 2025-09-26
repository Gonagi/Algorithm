import java.io.*;
import java.util.*;

public class Main {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N, K, L;
    static int[][] map;
    static boolean[][] visited;

    static class Node {
        int time;
        char dir;

        public Node(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class Node2 {
        int y, x;

        public Node2(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int idx = 0; idx < K; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }

        L = Integer.parseInt(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        for (int idx = 0; idx < L; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            deque.add(new Node(X, C));
        }

        Deque<Node2> que2 = new ArrayDeque<>();
        que2.add(new Node2(1, 1));
        visited[1][1] = true;
        int t = 1, dir = 0;
        while (!que2.isEmpty()) {
            Node2 curNode = que2.peekLast();
            int nextY = curNode.y + DIRECTIONS[dir][0];
            int nextX = curNode.x + DIRECTIONS[dir][1];

            if (!canMove(nextY, nextX) || visited[nextY][nextX]) {
                bw.write(t + "\n");
                break;
            }

            visited[nextY][nextX] = true;
            que2.add(new Node2(nextY, nextX));

            if (map[nextY][nextX] == 1) {
                map[nextY][nextX] = 0;
            } else {
                Node2 tail = que2.pollFirst();
                visited[tail.y][tail.x] = false;
            }

            if (!deque.isEmpty() && deque.peek().time == t) {
                Node dNode = deque.poll();
                if (dNode.dir == 'L')
                    dir = (dir + 3) % 4;
                else
                    dir = (dir + 1) % 4;
            }

            t++;
        }

        bw.flush();
        br.close();
        bw.close();

    }

    private static boolean canMove(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= N;
    }
}


import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int y, x, sum;

        public Node(int y, int x, int sum) {
            this.y = y;
            this.x = x;
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.sum, o.sum);
        }
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int[][] map, value;
    static int m, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        value = new int[m][n];

        for (int y = 0; y < m; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                value[y][x] = 123456789;
            }
        }

        if (map[0][0] == -1 || map[m - 1][n - 1] == -1) {
            bw.write("-1\n");
            bw.flush();
            br.close();
            bw.close();
            return;
        }
        PriorityQueue<Node> que = new PriorityQueue<>();
        value[0][0] = map[0][0] == 0 ? 0 : map[0][0];
        que.add(new Node(0, 0, value[0][0]));

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            if (curNode.y == m - 1 && curNode.x == n - 1) {
                break;
            }
            for (int[] dir : directions) {
                int nextY = curNode.y + dir[0];
                int nextX = curNode.x + dir[1];
                if (canMove(nextY, nextX) && map[nextY][nextX] != -1) {
                    if (value[nextY][nextX] > value[curNode.y][curNode.x] + map[nextY][nextX]) {
                        value[nextY][nextX] = value[curNode.y][curNode.x] + map[nextY][nextX];
                        que.add(new Node(nextY, nextX, value[nextY][nextX]));
                    }
                }
            }
        }

        if (value[m - 1][n - 1] == 123456789) {
            bw.write("-1\n");
        } else {
            bw.write(value[m - 1][n - 1] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < m && x >= 0 && x < n;
    }
}


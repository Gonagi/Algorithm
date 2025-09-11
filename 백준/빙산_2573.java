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

    static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int N, M, count, curCount;
    static int[][] map;
    static boolean[][] checkMap;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Queue<Node> que1 = new ArrayDeque<>();
        Queue<Node> que2 = new ArrayDeque<>();

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] != 0) {
                    que1.add(new Node(y, x));
                }
            }
        }

        for (int time = 1;; time++) {
            int size = que1.size();
            checkMap = new boolean[N][M];

            if (size == 0) {
                bw.write("0\n");
                break;
            }

            while (!que1.isEmpty()) {
                Node curNode = que1.poll();

                int check = 0;
                for (int[] dir : DIRECTIONS) {
                    int nextY = curNode.y + dir[0];
                    int nextX = curNode.x + dir[1];

                    if (canMove(nextY, nextX) && map[nextY][nextX] == 0 && !checkMap[nextY][nextX]) {
                        check++;
                    }
                }

                if (map[curNode.y][curNode.x] <= check) {
                    map[curNode.y][curNode.x] = 0;
                    checkMap[curNode.y][curNode.x] = true;
                } else {
                    map[curNode.y][curNode.x] -= check;
                    que2.add(curNode);
                }
            }

            if (que2.isEmpty()) {
                bw.write("0\n");
                break;
            }

            visited = new boolean[N][M];
            Node curNode = que2.peek();
            curCount = 0;
            visited[curNode.y][curNode.x] = true;
            dfs(curNode.y, curNode.x);

            if (curCount != que2.size()) {
                bw.write(time + "\n");
                break;
            }
            que1 = new ArrayDeque<>(que2);
            que2.clear();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    private static void dfs(int y, int x) {
        curCount++;
        for (int[] dir : DIRECTIONS) {
            int nextY = y + dir[0];
            int nextX = x + dir[1];

            if (canMove(nextY, nextX) && map[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                dfs(nextY, nextX);
            }
        }
    }
}


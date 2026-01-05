import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x, color, time;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int color, int time) {
            this.y = y;
            this.x = x;
            this.color = color;
            this.time = time;
        }
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M, G, R, max;
    static int[][] map;
    static int[] select;
    static Node[] canGrow;
    static int size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        List<Node> list = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) {
                    list.add(new Node(y, x));
                }
            }
        }

        canGrow = list.toArray(new Node[0]);
        size = canGrow.length;
        select = new int[size];

        dfs(0, 0, 0);
        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int idx, int greenCount, int redCount) {
        if (idx == size) {
            if (greenCount == G && redCount == R) {
                bfs();
            }
            return;
        }

        select[idx] = 0;
        dfs(idx + 1, greenCount, redCount);

        if (greenCount < G) {
            select[idx] = 1;
            dfs(idx + 1, greenCount + 1, redCount);
        }

        if (redCount < R) {
            select[idx] = 2;
            dfs(idx + 1, greenCount, redCount + 1);
        }
    }

    private static void bfs() {
        int[][] visitColor = new int[N][M];
        int[][] visitTime = new int[N][M];
        boolean[][] flower = new boolean[N][M];
        Queue<Node> que = new ArrayDeque<>();
        int count = 0;
        for (int idx = 0; idx < size; idx++) {
            Node node = canGrow[idx];
            if (select[idx] == 1) {
                que.add(new Node(node.y, node.x, 1, 0));
                visitColor[node.y][node.x] = 1;
                visitTime[node.y][node.x] = 0;
            } else if (select[idx] == 2) {
                que.add(new Node(node.y, node.x, 2, 0));
                visitColor[node.y][node.x] = 2;
                visitTime[node.y][node.x] = 0;
            }
        }

        while (!que.isEmpty()) {
            Node curNode = que.poll();

            if (flower[curNode.y][curNode.x]) {
                continue;
            }

            for (int[] dir : directions) {
                int nextY = curNode.y + dir[0];
                int nextX = curNode.x + dir[1];
                if (!canMove(nextY, nextX) || map[nextY][nextX] == 0 || flower[nextY][nextX]) {
                    continue;
                }
                if (visitColor[nextY][nextX] == 0) {
                    que.add(new Node(nextY, nextX, curNode.color, curNode.time + 1));
                    visitColor[nextY][nextX] = curNode.color;
                    visitTime[nextY][nextX] = curNode.time + 1;
                } else if (visitColor[nextY][nextX] != curNode.color && visitTime[nextY][nextX] == curNode.time + 1) {
                    flower[nextY][nextX] = true;
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}


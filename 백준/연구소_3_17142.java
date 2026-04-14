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
    static int[][] map, timeMap;
    static boolean[] check;
    static int N, M, size, result = Integer.MAX_VALUE;
    static List<Node> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        list = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) {
                    list.add(new Node(y, x));
                }
            }
        }
        br.close();
        size = list.size();
        check = new boolean[size];
        dfs(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void dfs(int cur, int count) {
        if (count == M) {
            bfs();
            findValue();
        }

        for (int idx = cur; idx < size; idx++) {
            if (!check[idx]) {
                check[idx] = true;
                dfs(idx + 1, count + 1);
                check[idx] = false;
            }
        }
    }

    private static void bfs() {
        timeMap = new int[N][N];
        boolean[][] visitedMap = new boolean[N][N];
        Queue<Node> que = new ArrayDeque<>();
        for (int idx = 0; idx < size; idx++) {
            Node curNode = list.get(idx);
            if (check[idx]) {
                que.add(curNode);
                visitedMap[curNode.y][curNode.x] = true;
            }
        }

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            for (int[] dir : directions) {
                int nextY = curNode.y + dir[0];
                int nextX = curNode.x + dir[1];
                if (!canMove(nextY, nextX) || map[nextY][nextX] == 1
                        || visitedMap[nextY][nextX]) {
                    continue;
                }
                visitedMap[nextY][nextX] = true;
                timeMap[nextY][nextX] = timeMap[curNode.y][curNode.x] + 1;
                que.add(new Node(nextY, nextX));
            }
        }
    }

    private static void findValue() {
        int maxTime = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 0) {
                    if (timeMap[y][x] == 0) {
                        return;
                    }
                    maxTime = Math.max(maxTime, timeMap[y][x]);
                }
            }
        }
        result = Math.min(result, maxTime);
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}


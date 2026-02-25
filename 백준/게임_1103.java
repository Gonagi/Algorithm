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
    static char[][] map;
    static int[][] dpMap;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dpMap = new int[N][M];
        visited = new boolean[N][M];

        for (int y = 0; y < N; y++) {
            String inputX = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = inputX.charAt(x);
            }
        }
        br.close();

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int y, int x) {
        if (!canMove(y, x) || map[y][x] == 'H') {
            return 0;
        }

        if (visited[y][x]) {
            return -1;
        }

        if (dpMap[y][x] != 0) {
            return dpMap[y][x];
        }

        int max = -1;
        visited[y][x] = true;
        for (int[] dir : directions) {
            int nextY = y + (map[y][x] - '0') * dir[0];
            int nextX = x + (map[y][x] - '0') * dir[1];
            int nextValue = dfs(nextY, nextX);
            if (nextValue == -1) {
                visited[y][x] = false;
                return -1;
            }
            max = Math.max(max, nextValue);
        }
        visited[y][x] = false;

        return dpMap[y][x] = max + 1;
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}


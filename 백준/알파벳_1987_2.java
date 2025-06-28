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

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static int R, C, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int y = 0; y < R; y++) {
            String inputX = br.readLine();
            for (int x = 0; x < C; x++) {
                map[y][x] = inputX.charAt(x);
            }
        }

        DFS(0, 0, 1, 1 << map[0][0] - 'A');

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void DFS(int y, int x, int count, int visited) {
        result = Math.max(result, count);

        for (int[] dir : DIRECTIONS) {
            int nextY = y + dir[0];
            int nextX = x + dir[1];

            if (canMove(nextY, nextX) && (visited & (1 << map[nextY][nextX] - 'A')) == 0) {
                DFS(nextY, nextX, count + 1, visited | (1 << map[nextY][nextX] - 'A'));
            }
        }
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}


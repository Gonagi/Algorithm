import java.io.*;
import java.util.*;

class Solution {
    static class Direction {
        int y, x;

        public Direction(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, minLength, maxCore;
    static int[][] map, directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<Direction> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            minLength = Integer.MAX_VALUE;
            maxCore = 0;
            map = new int[N][N];
            list = new ArrayList<>();
            for (int y = 0; y < N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                    if (map[y][x] == 1 && !(y == 0 || y == N - 1 || x == 0 || x == N - 1)) {
                        list.add(new Direction(y, x));
                    }
                }
            }

            DFS(0, 0, 0);

            bw.write("#" + testCase + " " + minLength + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void DFS(int idx, int count, int length) {
        if (idx == list.size()) {
            if (count > maxCore) {
                maxCore = count;
                minLength = length;
            } else if (count == maxCore) {
                minLength = Math.min(minLength, length);
            }
            return;
        }
        Direction cur = list.get(idx);
        int y = cur.y;
        int x = cur.x;

        for (int[] d : directions) {
            if (canLay(y, x, d)) {
                int len = layWire(y, x, d, 2);
                DFS(idx + 1, count + 1, length + len);
                layWire(y, x, d, 0);
            }
        }
        DFS(idx + 1, count, length);
    }

    static boolean canLay(int y, int x, int[] dir) {
        int ny = y + dir[0];
        int nx = x + dir[1];
        while (canMove(ny, nx)) {
            if (map[ny][nx] != 0)
                return false;
            ny += dir[0];
            nx += dir[1];
        }
        return true;
    }

    static int layWire(int y, int x, int[] dir, int value) {
        int ny = y + dir[0];
        int nx = x + dir[1];
        int len = 0;
        while (canMove(ny, nx)) {
            map[ny][nx] = value;
            len++;
            ny += dir[0];
            nx += dir[1];
        }
        return len;
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}


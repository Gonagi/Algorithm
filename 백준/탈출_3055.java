package Daily10.geonhak;

import java.io.*;
import java.util.*;

public class Main_3055 {
    static class Direction {
        int y, x;
        char value;

        public Direction(int y, int x, char value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }

    static int R, C;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static int[][] time;
    static Direction start;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        time = new int[R][C];
        Queue<Direction> que = new ArrayDeque<>();

        for (int y = 0; y < R; y++) {
            String mapX = br.readLine();
            for (int x = 0; x < C; x++) {
                map[y][x] = mapX.charAt(x);
                if (map[y][x] == 'S') {
                    start = new Direction(y, x, 'S');
                } else if (map[y][x] == '*') {
                    que.add(new Direction(y, x, '*'));
                }
            }
        }

        int result = -1;
        que.add(start);
        while (!que.isEmpty()) {
            Direction cur = que.poll();
            int y = cur.y;
            int x = cur.x;
            char value = cur.value;

            if (value == '*') {
                for (int[] dir : directions) {
                    int nextY = y + dir[0];
                    int nextX = x + dir[1];
                    if (!canMove(nextY, nextX) || map[nextY][nextX] == '*' || map[nextY][nextX] == 'X'
                            || map[nextY][nextX] == 'D') {
                        continue;
                    }
                    que.add(new Direction(nextY, nextX, value));
                    map[nextY][nextX] = '*';
                }
            } else {
                if (map[y][x] == 'D') {
                    result = time[y][x];
                    break;
                }
                for (int[] dir : directions) {
                    int nextY = y + dir[0];
                    int nextX = x + dir[1];
                    if (!canMove(nextY, nextX) || map[nextY][nextX] == '*' || map[nextY][nextX] == 'X'
                            || time[nextY][nextX] != 0) {
                        continue;
                    }
                    que.add(new Direction(nextY, nextX, value));
                    time[nextY][nextX] = time[y][x] + 1;
                }

            }
        }

        if (result == -1) {
            bw.write("KAKTUS\n");
        } else {
            bw.write(result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}


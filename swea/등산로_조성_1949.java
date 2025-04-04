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

    static int N, K, result;
    static int[][] map, directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static List<Direction> starts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            result = 0;

            map = new int[N][N];
            visited = new boolean[N][N];
            starts = new ArrayList<>();
            int maxHeight = 0;
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[y][x]);
                }
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] == maxHeight) {
                        visited[y][x] = true;
                        starts.add(new Direction(y, x));
                        visited[y][x] = false;
                    }
                }
            }

            for (Direction start : starts) {
                int startY = start.y;
                int startX = start.x;
                visited[startY][startX] = true;
                DFS(startY, startX, 1, map[startY][startX], K);
                visited[startY][startX] = false;
            }
            bw.write("#" + testCase + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void DFS(int y, int x, int count, int height, int k) {
        result = Math.max(count, result);

        for (int[] d : directions) {
            int nextY = y + d[0];
            int nextX = x + d[1];
            if (!canMove(nextY, nextX) || visited[nextY][nextX]) {
                continue;
            }

            if (k == 0) {
                if (map[nextY][nextX] < height) {
                    visited[nextY][nextX] = true;
                    DFS(nextY, nextX, count + 1, map[nextY][nextX], k);
                    visited[nextY][nextX] = false;
                }
            } else {
                if (map[nextY][nextX] < height) {
                    visited[nextY][nextX] = true;
                    DFS(nextY, nextX, count + 1, map[nextY][nextX], k);
                    visited[nextY][nextX] = false;
                } else if ((map[nextY][nextX] - k) < height) {
                    visited[nextY][nextX] = true;
                    DFS(nextY, nextX, count + 1, height - 1, 0);
                    visited[nextY][nextX] = false;
                }
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}


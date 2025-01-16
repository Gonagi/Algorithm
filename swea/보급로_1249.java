import java.io.*;
import java.util.*;

public class Solution {
    static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N;
    static int[][] map = new int[100][100];

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(BR.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(BR.readLine().trim());
            for (int y = 0; y < N; y++) {
                String mapX = BR.readLine().trim();
                for (int x = 0; x < N; x++) {
                    map[y][x] = Character.getNumericValue(mapX.charAt(x));
                }
            }

            boolean[][] visited = new boolean[100][100];
            int[][] count = new int[100][100];
            Queue<int[]> que = getInitialQueue(visited, count);

            while (!que.isEmpty()) {
                int[] cur = que.poll();
                int cy = cur[0], cx = cur[1];
                visited[cy][cx] = true;

                for (int[] d : DIRECTIONS) {
                    int ny = cy + d[0];
                    int nx = cx + d[1];
                    if (!canMove(ny, nx)) {
                        continue;
                    }
                    if (!visited[ny][nx] && map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        count[ny][nx] = count[cy][cx];
                        que.add(new int[]{ny, nx});
                    } else if (!visited[ny][nx] || count[ny][nx] > count[cy][cx] + map[ny][nx]) {
                        visited[ny][nx] = true;
                        count[ny][nx] = count[cy][cx] + map[ny][nx];
                        que.add(new int[]{ny, nx});
                    }
                }
            }
            System.out.printf("#%d %d\n", testCase, count[N - 1][N - 1]);
        }
    }

    private static Queue<int[]> getInitialQueue(final boolean[][] visited, final int[][] count) {
        Queue<int[]> que = new ArrayDeque<>();

        visited[0][0] = true;

        que.add(new int[]{0, 1});
        visited[0][1] = true;
        count[0][1] = map[0][1];

        que.add(new int[]{1, 0});
        visited[1][0] = true;
        count[1][0] = map[1][0];

        return que;
    }

    public static boolean canMove(final int y, final int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}

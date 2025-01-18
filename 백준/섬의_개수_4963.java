import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[][] directions = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
    static List<int[]> grounds;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];
            grounds = new ArrayList<>();
            for (int y = 0; y < h; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < w; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                    if (map[y][x] == 1) {
                        grounds.add(new int[]{y, x});
                    }
                }
            }

            int result = 0;
            for (int[] ground : grounds) {
                if (visited[ground[0]][ground[1]]) {
                    continue;
                }
                result++;
                bfs(ground);
            }
            System.out.println(result);
        }
    }

    static void bfs(int[] ground) {
        Queue<int[]> que = new ArrayDeque<>();
        visited[ground[0]][ground[1]] = true;
        que.add(ground);

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int[] dir : directions) {
                int nextY = cur[0] + dir[0];
                int nextX = cur[1] + dir[1];
                if (!canMove(nextY, nextX) || visited[nextY][nextX] || map[nextY][nextX] == 0) {
                    continue;
                }
                visited[nextY][nextX] = true;
                que.add(new int[]{nextY, nextX});
            }
        }

    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}

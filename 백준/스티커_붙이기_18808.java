import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int idx = 0; idx < K; idx++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[R][C];
            for (int y = 0; y < R; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < C; x++) {
                    sticker[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            boolean placed = false;
            int[][] cur = sticker;

            // 0, 90, 180, 270도 회전 시도
            for (int rot = 0; rot < 4 && !placed; rot++) {
                int h = cur.length;
                int w = cur[0].length;

                for (int y = 0; y <= N - h && !placed; y++) {
                    for (int x = 0; x <= M - w; x++) {
                        if (canPut(cur, y, x)) {
                            put(cur, y, x);
                            placed = true;
                            break;
                        }
                    }
                }

                // 다음 회전 준비
                cur = rotate90(cur);
            }
        }

        int count = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
    // 현재 스티커(cur)를 (r, c)에 붙일 수 있는지 검사
    private static boolean canPut(int[][] cur, int r, int c) {
        int h = cur.length;
        int w = cur[0].length;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (cur[y][x] == 1 && map[r + y][c + x] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // 현재 스티커(cur)를 (r, c)에 붙이기
    private static void put(int[][] cur, int r, int c) {
        int h = cur.length;
        int w = cur[0].length;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (cur[y][x] == 1) {
                    map[r + y][c + x] = 1;
                }
            }
        }
    }

    // 시계 방향 90도 회전
    private static int[][] rotate90(int[][] src) {
        int h = src.length;
        int w = src[0].length;
        int[][] rotated = new int[w][h];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                rotated[x][h - 1 - y] = src[y][x];
            }
        }
        return rotated;
    }
}


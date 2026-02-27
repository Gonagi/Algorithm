import java.io.*;
import java.util.*;

public class Main {
    static int N, result1, result2, result3;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        check(N, 0, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(result1).append('\n').append(result2).append('\n').append(result3);
        System.out.println(sb);
        br.close();
    }

    private static void check(int size, int curY, int curX) {
        int firstValue = map[curY][curX];
        int nextSize = size / 3;
        for (int y = curY; y < curY + size; y++) {
            for (int x = curX; x < curX + size; x++) {
                if (map[y][x] != firstValue) {
                    for (int dY = 0; dY < 3; dY++) {
                        for (int dX = 0; dX < 3; dX++) {
                            check(nextSize, curY + dY * nextSize, curX + dX * nextSize);
                        }
                    }
                    return;
                }
            }
        }

        if (firstValue == -1) {
            result1++;
        } else if (firstValue == 0) {
            result2++;
        } else {
            result3++;
        }
    }
}


import java.io.*;
import java.util.*;

public class Main {
    static int whiteCount, blueCount;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);
        StringBuilder sb = new StringBuilder();
        sb.append(whiteCount).append('\n').append(blueCount);
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int curY, int curX, int curSize) {
        int firstValue = map[curY][curX];
        int nextSize = curSize / 2;

        for (int y = 0; y < curSize; y++) {
            for (int x = 0; x < curSize; x++) {
                if (firstValue != map[curY + y][curX + x]) {
                    dfs(curY, curX, nextSize);
                    dfs(curY, curX + nextSize, nextSize);
                    dfs(curY + nextSize, curX, nextSize);
                    dfs(curY + nextSize, curX + nextSize, nextSize);
                    return;
                }
            }
        }
        if (firstValue == 0) {
            whiteCount++;
        } else {
            blueCount++;
        }
    }
}


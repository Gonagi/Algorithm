import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        int[][] sum = new int[N + 1][M + 1];
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                sum[y][x] = map[y][x];
            }
        }

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                sum[y][x] += sum[y - 1][x] + sum[y][x - 1] - sum[y - 1][x - 1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < K; idx++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(sum[x][y] - sum[i - 1][y] - sum[x][j - 1] + sum[i - 1][j - 1]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}


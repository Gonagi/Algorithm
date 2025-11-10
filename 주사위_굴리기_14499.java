import java.io.*;
import java.util.*;

public class Main {
    static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[7];
        st = new StringTokenizer(br.readLine());
        int nextY = y, nextX = x;
        for (int idx = 0; idx < K; idx++) {
            int dir = Integer.parseInt(st.nextToken());
            nextY += directions[dir - 1][0];
            nextX += directions[dir - 1][1];
            if (!canMove(nextY, nextX, N, M)) {
                nextY -= directions[dir - 1][0];
                nextX -= directions[dir - 1][1];
                continue;
            }

            if (dir == 1) {
                int temp1 = dice[1];
                int temp3 = dice[3];
                int temp4 = dice[4];
                int temp6 = dice[6];
                dice[1] = temp4;
                dice[3] = temp1;
                dice[4] = temp6;
                dice[6] = temp3;
            } else if (dir == 2) {
                int temp1 = dice[1];
                int temp3 = dice[3];
                int temp4 = dice[4];
                int temp6 = dice[6];
                dice[1] = temp3;
                dice[3] = temp6;
                dice[4] = temp1;
                dice[6] = temp4;
            } else if (dir == 3) {
                int temp1 = dice[1];
                int temp2 = dice[2];
                int temp5 = dice[5];
                int temp6 = dice[6];
                dice[1] = temp5;
                dice[2] = temp1;
                dice[5] = temp6;
                dice[6] = temp2;
            } else {
                int temp1 = dice[1];
                int temp2 = dice[2];
                int temp5 = dice[5];
                int temp6 = dice[6];
                dice[1] = temp2;
                dice[2] = temp6;
                dice[5] = temp1;
                dice[6] = temp5;
            }

            if (map[nextY][nextX] == 0) {
                map[nextY][nextX] = dice[6];
            } else {
                dice[6] = map[nextY][nextX];
                map[nextY][nextX] = 0;
            }
            bw.write(dice[1] + "\n");

        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean canMove(int nextY, int nextX, int N, int M) {
        return nextY >= 0 && nextY < N && nextX >= 0 && nextX < M;
    }
}


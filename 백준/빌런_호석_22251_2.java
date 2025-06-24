import java.io.*;
import java.util.*;

public class Main {
    static int N, K, P, X, result;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[10][10];
        map[0][1] = map[1][0] = 4;
        map[0][2] = map[2][0] = 3;
        map[0][3] = map[3][0] = 3;
        map[0][4] = map[4][0] = 4;
        map[0][5] = map[5][0] = 3;
        map[0][6] = map[6][0] = 2;
        map[0][7] = map[7][0] = 3;
        map[0][8] = map[8][0] = 1;
        map[0][9] = map[9][0] = 2;

        map[1][2] = map[2][1] = 5;
        map[1][3] = map[3][1] = 3;
        map[1][4] = map[4][1] = 2;
        map[1][5] = map[5][1] = 5;
        map[1][6] = map[6][1] = 6;
        map[1][7] = map[7][1] = 1;
        map[1][8] = map[8][1] = 5;
        map[1][9] = map[9][1] = 4;

        map[2][3] = map[3][2] = 2;
        map[2][4] = map[4][2] = 5;
        map[2][5] = map[5][2] = 4;
        map[2][6] = map[6][2] = 3;
        map[2][7] = map[7][2] = 4;
        map[2][8] = map[8][2] = 2;
        map[2][9] = map[9][2] = 3;

        map[3][4] = map[4][3] = 3;
        map[3][5] = map[5][3] = 2;
        map[3][6] = map[6][3] = 3;
        map[3][7] = map[7][3] = 2;
        map[3][8] = map[8][3] = 2;
        map[3][9] = map[9][3] = 1;

        map[4][5] = map[5][4] = 3;
        map[4][6] = map[6][4] = 4;
        map[4][7] = map[7][4] = 3;
        map[4][8] = map[8][4] = 3;
        map[4][9] = map[9][4] = 2;

        map[5][6] = map[6][5] = 1;
        map[5][7] = map[7][5] = 4;
        map[5][8] = map[8][5] = 2;
        map[5][9] = map[9][5] = 1;

        map[6][7] = map[7][6] = 5;
        map[6][8] = map[8][6] = 1;
        map[6][9] = map[9][6] = 2;

        map[7][8] = map[8][7] = 4;
        map[7][9] = map[9][7] = 3;

        map[8][9] = map[9][8] = 1;

        check(0, 1, 0, 0);

        bw.write((result - 1) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static private void check(int where, int ten, int now, int cnt) {
        if (now > N || cnt > P) {
            return;
        }

        if (where == K) {
            if (now != 0) {
                result++;
            }
            return;
        }

        int digit = (X / ten) % 10;

        for (int num = 0; num < 10; num++) {
            check(where + 1, ten * 10, num * ten + now, cnt + map[digit][num]);
        }
    }
}


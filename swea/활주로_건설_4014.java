import java.io.*;
import java.util.*;

class Solution {
    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int idx = 0; idx < N; idx++) {
                if (checkRight(idx)) {
                    count++;
                }
                if (checkDown(idx)) {
                    count++;
                }
            }
            bw.write("#" + testCase + " " + count + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static boolean checkRight(int y) {
        int prevHeight = map[y][0];
        int count = 1;
        for (int x = 1; x < N; x++) {
            int curHeight = map[y][x];
            if (prevHeight == curHeight) {
                count++;
            } else if (prevHeight + 1 == curHeight) {
                if (count >= X) {
                    count = 1;
                    prevHeight = curHeight;
                } else {
                    return false;
                }
            } else if (prevHeight - 1 == curHeight) {
                count = 0;
                int nextX = x;
                for (; nextX < x + X; nextX++) {
                    if (nextX >= N) {
                        return false;
                    }
                    if (curHeight != map[y][nextX]) {
                        return false;
                    }
                    prevHeight = curHeight;
                    count = 0;
                }
                x = nextX - 1;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean checkDown(int x) {
        int prevHeight = map[0][x];
        int count = 1;
        for (int y = 1; y < N; y++) {
            int curHeight = map[y][x];
            if (prevHeight == curHeight) {
                count++;
            } else if (prevHeight + 1 == curHeight) {
                if (count >= X) {
                    count = 1;
                    prevHeight = curHeight;
                } else {
                    return false;
                }
            } else if (prevHeight - 1 == curHeight) {
                count = 0;
                int nextY = y;
                for (; nextY < y + X; nextY++) {
                    if (nextY >= N) {
                        return false;
                    }
                    if (curHeight != map[nextY][x]) {
                        return false;
                    }
                    prevHeight = curHeight;
                    count = 0;
                }
                y = nextY - 1;
            } else {
                return false;
            }
        }
        return true;
    }
}


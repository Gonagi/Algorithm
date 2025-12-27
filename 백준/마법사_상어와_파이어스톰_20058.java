import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, Q, size, maxSize, curSize;
    static int[][] A;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        size = 1;
        for (int idx = 0; idx < N; idx++) {
            size *= 2;
        }
        A = new int[size][size];
        for (int y = 0; y < size; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < size; x++) {
                A[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] input = new int[Q];
        for (int idx = 0; idx < Q; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
        }

        for (int idx = 0; idx < Q; idx++) {
            move(input[idx]);
            decrease();
        }

        bw.write(String.valueOf(sum()));
        bw.newLine();
        findMaxSize();
        bw.write(String.valueOf(maxSize));

        bw.flush();
        br.close();
        bw.close();
    }

    private static void findMaxSize() {
        maxSize = 0;
        visited = new boolean[size][size];

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (!visited[y][x] && A[y][x] > 0) {
                    curSize = 0;
                    dfs(y, x);
                    maxSize = Math.max(maxSize, curSize);
                }
            }
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        curSize++;

        for (int dir[] : directions) {
            int nextY = y + dir[0];
            int nextX = x + dir[1];

            if (canMove(nextY, nextX) && !visited[nextY][nextX] && A[nextY][nextX] > 0) {
                dfs(nextY, nextX);
            }
        }
    }

    private static int sum() {
        int sum = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                sum += A[y][x];
            }
        }
        return sum;
    }

    private static void decrease() {
        int[][] newA = new int[size][size];

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                int count = 0;
                for (int[] dir : directions) {
                    int nextY = y + dir[0];
                    int nextX = x + dir[1];
                    if (canMove(nextY, nextX)) {
                        if (A[nextY][nextX] != 0) {
                            count++;
                        }
                    }
                }
                if (count < 3 && A[y][x] > 0) {
                    newA[y][x] = A[y][x] - 1;
                } else {
                    newA[y][x] = A[y][x];
                }
            }
        }

        A = newA;
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < size && x >= 0 && x < size;
    }

    private static void move(int l) {
        int[][] newA = new int[size][size];
        int lSize = 1;
        for (int idx = 0; idx < l; idx++) {
            lSize *= 2;
        }

        for (int y = 0; y < size; y += lSize) {
            for (int x = 0; x < size; x += lSize) {
                for (int r = 0; r < lSize; r++) {
                    for (int c = 0; c < lSize; c++) {
                        newA[y + r][x + lSize - 1 - c] = A[y + c][x + r];
                    }
                }
            }
        }

        A = newA;
    }
}


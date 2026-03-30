import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, s;

        public Node(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    private static int N, M, K;
    private static boolean[] check;
    private static int[] order;
    private static Node[] nodes;
    private static int min = Integer.MAX_VALUE;
    static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                A[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        nodes = new Node[K];
        for (int idx = 0; idx < K; idx++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            nodes[idx] = new Node(r, c, s);
        }

        check = new boolean[K];
        order = new int[K];
        dfs(0);

        System.out.println(min);

        br.close();
    }

    private static void dfs(int cur) {
        if (cur == K) {
            int[][] copyA = new int[N][M];
            for (int y = 0; y < N; y++) {
                copyA[y] = A[y].clone();
            }

            for (int o : order) {
                Node node = nodes[o];
                simulation(node.r, node.c, node.s, copyA);
            }

            for (int y = 0; y < N; y++) {
                int sum = 0;
                for (int x = 0; x < M; x++) {
                    sum += copyA[y][x];
                }
                min = Math.min(min, sum);
            }
        }

        for (int idx = 0; idx < K; idx++) {
            if (!check[idx]) {
                check[idx] = true;
                order[cur] = idx;
                dfs(cur + 1);
                check[idx] = false;
            }
        }
    }

    private static void simulation(int r, int c, int s, int[][] copyA) {
        for (int layer = 1; layer <= s; layer++) {
            int top = r - layer - 1;
            int left = c - layer - 1;
            int bottom = r + layer - 1;
            int right = c + layer - 1;

            int temp = copyA[top][left];

            for (int idx = top; idx < bottom; idx++) {
                copyA[idx][left] = copyA[idx + 1][left];
            }

            for (int idx = left; idx < right; idx++) {
                copyA[bottom][idx] = copyA[bottom][idx + 1];
            }

            for (int idx = bottom; idx > top; idx--) {
                copyA[idx][right] = copyA[idx - 1][right];
            }

            for (int idx = right; idx > left; idx--) {
                copyA[top][idx] = copyA[top][idx - 1];
            }

            copyA[top][left + 1] = temp;
        }
    }
}


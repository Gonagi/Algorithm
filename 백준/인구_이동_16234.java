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

    static int N, L, R;
    static int[][] A, directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                A[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int day = 0;; day++) {
            visited = new boolean[N][N];
            boolean check = true;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x]) {
                        check &= BFS(y, x);
                    }
                }
            }

            if (check) {
                bw.write(day + "\n");
                break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean BFS(int y, int x) {
        boolean check = true;
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(y, x));
        int sum = A[y][x];
        List<Node> list = new ArrayList<>();
        list.add(new Node(y, x));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            visited[cur.y][cur.x] = true;
            int curValue = A[cur.y][cur.x];

            for (int[] d : directions) {
                int nextY = cur.y + d[0];
                int nextX = cur.x + d[1];
                if (canMove(nextY, nextX) && !visited[nextY][nextX]) {
                    int nextValue = A[nextY][nextX];
                    int diff = Math.abs(curValue - nextValue);
                    if (diff >= L && diff <= R) {
                        sum += nextValue;
                        que.add(new Node(nextY, nextX));
                        visited[nextY][nextX] = true;
                        list.add(new Node(nextY, nextX));
                        check = false;
                    }
                }
            }

        }

        if (!check) {
            int newValue = sum / list.size();
            for (Node n : list) {
                A[n.y][n.x] = newValue;
            }
        }

        return check;
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}


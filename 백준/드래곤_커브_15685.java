import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static boolean[][] visited = new boolean[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Node> list = new ArrayList<>();
            int nextX = x + directions[d][0];
            int nextY = y + directions[d][1];
            list.add(new Node(x, y));
            visited[x][y] = true;
            list.add(new Node(nextX, nextY));
            visited[nextX][nextY] = true;

            for (int count = 0; count < g; count++) {
                int size = list.size();
                Node end = list.get(size - 1);

                for (int idx2 = size - 2; idx2 >= 0; idx2--) {
                    Node cur = list.get(idx2);
                    int nX = end.x - (cur.y - end.y);
                    int nY = end.y + (cur.x - end.x);
                    Node nextNode = new Node(nX, nY);
                    visited[nX][nY] = true;
                    list.add(nextNode);
                }
            }
        }

        int result = 0;
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (visited[r][c] && visited[r + 1][c] &&
                        visited[r][c + 1] && visited[r + 1][c + 1]) {
                    result++;
                }

            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}


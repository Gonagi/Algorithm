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

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        Queue<Node> que = new ArrayDeque<>();

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1) {
                    que.add(new Node(y, x));
                }
            }
        }

        for (int time = 1;; time++) {
            boolean[][] outsideMap = new boolean[N][M];
            Queue<Node> outsideQue = new ArrayDeque<>();
            outsideQue.add(new Node(0, 0));
            outsideMap[0][0] = true;
            while (!outsideQue.isEmpty()) {
                Node curNode = outsideQue.poll();

                for (int[] dir : directions) {
                    int nextY = curNode.y + dir[0];
                    int nextX = curNode.x + dir[1];
                    if (canMove(nextY, nextX)) {
                        if (map[nextY][nextX] == 0 && !outsideMap[nextY][nextX]) {
                            outsideMap[nextY][nextX] = true;
                            outsideQue.add(new Node(nextY, nextX));
                        }
                    }
                }
            }

            Queue<Node> newQue = new ArrayDeque<>();
            while (!que.isEmpty()) {
                Node curNode = que.poll();
                int count = 0;
                for (int[] dir : directions) {
                    int nextY = curNode.y + dir[0];
                    int nextX = curNode.x + dir[1];
                    if (canMove(nextY, nextX)) {
                        if (outsideMap[nextY][nextX]) {
                            count++;
                        }
                    }
                }
                if (count >= 2) {
                    map[curNode.y][curNode.x] = 0;
                } else {
                    newQue.add(curNode);
                }
            }

            que = new ArrayDeque<>(newQue);
            if (que.isEmpty()) {
                bw.write(time + "\n");
                break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}


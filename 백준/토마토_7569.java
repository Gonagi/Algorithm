import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int z, y, x, time;

        public Node(int z, int y, int x, int time) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int[] X = {0, 0, 0, 0, 1, -1};
    static int[] Y = {0, 0, 1, -1, 0, 0};
    static int[] Z = {1, -1, 0, 0, 0, 0};
    static int M, N, H;
    static int[][][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        Queue<Node> que = new ArrayDeque<>();
        int remainCount = 0;

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    map[z][y][x] = Integer.parseInt(st.nextToken());
                    if (map[z][y][x] == 1) {
                        que.add(new Node(z, y, x, 0));
                        visited[z][y][x] = true;
                    }
                    if (map[z][y][x] == 0) {
                        remainCount++;
                    }
                }
            }
        }
        int resultTime = 0;

        if (remainCount == 0) {
            bw.write("0\n");
        } else {
            while (!que.isEmpty()) {
                Node curNode = que.poll();
                resultTime = curNode.time;
                for (int i = 0; i < 6; i++) {
                    int nextZ = curNode.z + Z[i];
                    int nextY = curNode.y + Y[i];
                    int nextX = curNode.x + X[i];
                    if (canMove(nextZ, nextY, nextX) && map[nextZ][nextY][nextX] != -1
                            && !visited[nextZ][nextY][nextX]) {
                        que.add(new Node(nextZ, nextY, nextX, curNode.time + 1));
                        visited[nextZ][nextY][nextX] = true;
                        remainCount--;
                    }
                }
            }

            if (remainCount != 0) {
                bw.write("-1\n");
            } else {
                bw.write(resultTime + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static boolean canMove(int z, int y, int x) {
        return z >= 0 && z < H && y >= 0 && y < N && x >= 0 && x < M;
    }
}


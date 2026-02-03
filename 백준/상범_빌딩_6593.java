import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int z, y, x;

        public Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static int[][] directions = {{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};
    static char[][][] map;
    static int[][][] visited;
    static int L, R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            map = new char[L][R][C];
            visited = new int[L][R][C];

            Queue<Node> que = new ArrayDeque<>();
            for (int l = 0; l < L; l++) {
                for (int y = 0; y < R; y++) {
                    String inputX = br.readLine();
                    for (int x = 0; x < C; x++) {
                        map[l][y][x] = inputX.charAt(x);
                        visited[l][y][x] = -1;
                        if (map[l][y][x] == 'S') {
                            que.add(new Node(l, y, x));
                            visited[l][y][x] = 0;
                        }
                    }
                }
                br.readLine();
            }

            boolean check = false;
            while (!que.isEmpty()) {
                Node curNode = que.poll();
                if (map[curNode.z][curNode.y][curNode.x] == 'E') {
                    sb.append("Escaped in ").append(visited[curNode.z][curNode.y][curNode.x]).append(" minute(s).\n");
                    check = true;
                    break;
                }
                for (int[] dir : directions) {
                    int nextZ = curNode.z + dir[0];
                    int nextY = curNode.y + dir[1];
                    int nextX = curNode.x + dir[2];
                    if (canMove(nextZ, nextY, nextX) && visited[nextZ][nextY][nextX] == -1 &&
                            map[nextZ][nextY][nextX] != '#') {
                        visited[nextZ][nextY][nextX] = visited[curNode.z][curNode.y][curNode.x] + 1;
                        que.add(new Node(nextZ, nextY, nextX));
                    }
                }
            }
            if (!check) {
                sb.append("Trapped!\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static private boolean canMove(int z, int y, int x) {
        return z >= 0 && z < L && y >= 0 && y < R && x >= 0 && x < C;
    }
}


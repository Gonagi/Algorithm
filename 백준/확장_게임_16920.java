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
    static char[][] map;
    static Queue<Node>[] playerCastles;
    static int N, M, P, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int[] S = new int[P + 1];
        playerCastles = new ArrayDeque[P + 1];
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= P; idx++) {
            S[idx] = Integer.parseInt(st.nextToken());
            playerCastles[idx] = new ArrayDeque<>();
        }

        map = new char[N][M];
        for (int y = 0; y < N; y++) {
            String inputX = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = inputX.charAt(x);
                if (map[y][x] >= '1' && map[y][x] <= '9') {
                    int player = map[y][x] - '0';
                    playerCastles[player].add(new Node(y, x));
                    count++;
                } else if (map[y][x] == '#') {
                    count++;
                }
            }
        }

        while (true) {
            boolean expanded = false;
            for (int player = 1; player <= P; player++) {
                int speed = S[player];
                for (int step = 0; step < speed; step++) {
                    int qSize = playerCastles[player].size();
                    if (qSize == 0) {
                        break;
                    }
                    for (int idx = 0; idx < qSize; idx++) {
                        Node cur = playerCastles[player].poll();
                        for (int[] dir : directions) {
                            int ny = cur.y + dir[0];
                            int nx = cur.x + dir[1];

                            if (canMove(ny, nx) && map[ny][nx] == '.') {
                                map[ny][nx] = (char) ('0' + player);
                                playerCastles[player].add(new Node(ny, nx));
                                expanded = true;
                            }
                        }
                    }
                }
            }

            if (!expanded) {
                break;
            }
        }
        int[] answer = new int[10];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] >= '1' && map[y][x] <= '9') {
                    answer[map[y][x] - '0']++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (
             int idx = 1; idx <= P; idx++) {
            sb.append(answer[idx]).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}


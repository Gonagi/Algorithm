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

    static int N, M, fuel, startY, startX;
    static int[][] map, clientStartMap, countMap;
    static int[] endY, endX;
    static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        clientStartMap = new int[N + 1][N + 1];
        countMap = new int[N + 1][N + 1];
        endY = new int[M + 1];
        endX = new int[M + 1];

        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());

        for (int idx = 1; idx <= M; idx++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            clientStartMap[sy][sx] = idx;
            endY[idx] = ey;
            endX[idx] = ex;
        }

        for (int t = 0; t < M; t++) {
            for (int y = 1; y <= N; y++) {
                Arrays.fill(countMap[y], -1);
            }

            Queue<Node> que = new ArrayDeque<>();
            que.add(new Node(startY, startX));
            countMap[startY][startX] = 0;

            while (!que.isEmpty()) {
                Node curNode = que.poll();
                for (int[] d : directions) {
                    int ny = curNode.y + d[0];
                    int nx = curNode.x + d[1];
                    if (!canMove(ny, nx) || map[ny][nx] == 1 || countMap[ny][nx] != -1) {
                        continue;
                    }

                    countMap[ny][nx] = countMap[curNode.y][curNode.x] + 1;
                    que.add(new Node(ny, nx));
                }
            }

            int minDist = Integer.MAX_VALUE;
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    if (clientStartMap[y][x] > 0 && countMap[y][x] != -1) {
                        minDist = Math.min(minDist, countMap[y][x]);
                    }
                }
            }

            if (minDist == Integer.MAX_VALUE || fuel < minDist) {
                System.out.println(-1);
                return;
            }

            int pickY = Integer.MAX_VALUE;
            int pickX = Integer.MAX_VALUE;
            int pickNum = -1;

            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    if (clientStartMap[y][x] > 0 && countMap[y][x] == minDist) {
                        if (y < pickY || (y == pickY && x < pickX)) {
                            pickY = y;
                            pickX = x;
                            pickNum = clientStartMap[y][x];
                        }
                    }
                }
            }

            fuel -= minDist;
            startY = pickY;
            startX = pickX;
            clientStartMap[pickY][pickX] = 0;

            for (int y = 1; y <= N; y++) {
                Arrays.fill(countMap[y], -1);
            }

            que = new ArrayDeque<>();
            que.add(new Node(startY, startX));
            countMap[startY][startX] = 0;
            boolean arrived = false;

            while (!que.isEmpty()) {
                Node curNode = que.poll();
                int dist = countMap[curNode.y][curNode.x];

                if (curNode.y == endY[pickNum] && curNode.x == endX[pickNum]) {
                    if (fuel < dist) {
                        System.out.println(-1);
                        return;
                    }
                    fuel = fuel - dist + dist * 2;
                    startY = curNode.y;
                    startX = curNode.x;
                    arrived = true;
                    break;
                }

                for (int[] d : directions) {
                    int ny = curNode.y + d[0];
                    int nx = curNode.x + d[1];

                    if (!canMove(ny, nx) || map[ny][nx] == 1 || countMap[ny][nx] != -1) {
                        continue;
                    }

                    countMap[ny][nx] = dist + 1;
                    que.add(new Node(ny, nx));
                }
            }

            if (!arrived) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(fuel);
    }

    static boolean canMove(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= N;
    }
}


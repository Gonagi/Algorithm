import java.io.*;
import java.util.*;
 
class Solution {
    static class Direction {
        int y, x;
 
        public Direction(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
 
    static int N, startY, startX;
    static int[][] map, bounce, directions;
    static Direction[][] wormholes;
    static List<Direction> starts;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N + 2][N + 2];
            directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            bounce = new int[6][4];
            bounce[1] = new int[]{2, 0, 3, 1};
            bounce[2] = new int[]{2, 3, 1, 0};
            bounce[3] = new int[]{1, 3, 0, 2};
            bounce[4] = new int[]{3, 2, 0, 1};
            bounce[5] = new int[]{2, 3, 0, 1};
 
            wormholes = new Direction[11][2];
            starts = new ArrayList<>();
 
            for (int y = 0; y <= N + 1; y++) {
                for (int x = 0; x <= N + 1; x++) {
                    map[y][x] = 5;
                }
            }
 
            for (int y = 1; y <= N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int x = 1; x <= N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                    if (map[y][x] >= 6) {
                        if (wormholes[map[y][x]][0] == null) {
                            wormholes[map[y][x]][0] = new Direction(y, x);
                        } else {
                            wormholes[map[y][x]][1] = new Direction(y, x);
                        }
                    }
                    else if (map[y][x] == 0) {
                        starts.add(new Direction(y, x));
                    }
                }
            }
 
            int result = 0;
            for (Direction start : starts) {
                for (int d = 0; d < 4; d++) {
                    startY = start.y;
                    startX = start.x;
                    result = Math.max(result, simulate(startY, startX, d));
                }
            }
 
            bw.write("#" + testCase + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
 
    static int simulate(int y, int x, int dir) {
        int count = 0;
 
        while (true) {
            int nextY = y + directions[dir][0];
            int nextX = x + directions[dir][1];
 
            if ((nextY == startY && nextX == startX) || map[nextY][nextX] == -1) {
                break;
            }
 
            if (map[nextY][nextX] == 0) {
                y = nextY;
                x = nextX;
            }
 
            else if (1 <= map[nextY][nextX] && map[nextY][nextX] <= 5) {
                count++;
                dir = bounce[map[nextY][nextX]][dir];
                y = nextY;
                x = nextX;
            }
 
            else if (6 <= map[nextY][nextX] && map[nextY][nextX] <= 10) {
                int wormhole = map[nextY][nextX];
                if (wormholes[wormhole][0].y == nextY && wormholes[wormhole][0].x == nextX) {
                    nextY = wormholes[wormhole][1].y;
                    nextX = wormholes[wormhole][1].x;
                } else {
                    nextY = wormholes[wormhole][0].y;
                    nextX = wormholes[wormhole][0].x;
                }
                y = nextY;
                x = nextX;
            }
        }
        return count;
    }
}


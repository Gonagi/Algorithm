import java.util.*;

class Solution {
    static int row;
    static int column;
    static Direction[] dir = new Direction[] { new Direction(1, 0), new Direction(-1, 0),
            new Direction(0, 1), new Direction(0, -1) };
    static int[][] Land;
    static int[][] visited = new int[501][501];
    static int[] landX = new int[501];
    static int count = -1;

    public int solution(int[][] land) {
        Land = land;
        row = land.length;
        column = land[0].length;

        for (int y = 0; y < row; y++) {
            for (int x = 0; x < column; x++) {
                if (Land[y][x] == 1 && visited[y][x] == 0) {
                    BFS(y, x);
                }
            }
        }

        int max = 0;
        for (int idx = 0; idx < column; idx++) {
            max = (max < landX[idx]) ? landX[idx] : max;
        }

        return max;
    }

    void BFS(int y, int x) {
        Queue<Direction> que = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        que.add(new Direction(y, x));
        visited[y][x] = 1;
        int check = 0;

        while (!que.isEmpty()) {
            Direction cur = que.poll();
            check++;
            Land[cur.y][cur.x] = count;
            set.add(cur.x);

            for (int d = 0; d < 4; d++) {
                Direction next = new Direction(cur.y + dir[d].y, cur.x + dir[d].x);
                if (canMovable(next) && visited[next.y][next.x] == 0) {
                    visited[next.y][next.x] = 1;
                    que.add(next);
                }
            }
        }

        for (int i : set) {
            landX[i] += check;
        }
    }

    boolean canMovable(Direction next) {
        return next.y >= 0 && next.y < row && next.x >= 0 && next.x < column && Land[next.y][next.x] == 1;
    }

    static class Direction {
        int y, x;

        Direction(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
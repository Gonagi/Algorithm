import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    static final class Direction {
    int y, x;
 
    public Direction(int y, int x) {
        this.y = y;
        this.x = x;
    }
    }
 
    static final Direction[] DIRECTIONS = { new Direction(0, 1), new Direction(1, 1), new Direction(1, 0),
        new Direction(1, -1), new Direction(0, -1), new Direction(-1, -1), new Direction(-1, 0),
        new Direction(-1, 1) };
 
    static int N;
 
    public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= T; testCase++) {
        N = Integer.parseInt(br.readLine());
        char[][] inputMap = new char[N][N];
        int[][] map = new int[N][N];
        input(inputMap);
        calMap(inputMap, map);
        int result = check(map);
 
        System.out.printf("#%d %d\n", testCase, result);
    }
    }
 
    private static int check(final int[][] map) {
    int[][] visited = new int[N][N];
    int count = calDependantArea(map, visited, 0);
    count = calIndependantArea(map, visited, count);
    return count;
    }
 
    private static int calDependantArea(final int[][] map, int[][] visited, int count) {
    for (int y = 0; y < N; y++) {
        for (int x = 0; x < N; x++) {
        if (map[y][x] == 0 && visited[y][x] == 0) {
            bfs(map, visited, y, x);
            count++;
        }
        }
    }
    return count;
    }
 
    private static int calIndependantArea(final int[][] map, final int[][] visited, int count) {
    for (int y = 0; y < N; y++) {
        for (int x = 0; x < N; x++) {
        if (visited[y][x] == -1 || map[y][x] == -1) {
            continue;
        }
        count++;
        }
    }
    return count;
    }
 
    private static void bfs(final int[][] map, int[][] visited, int y, int x) {
    Queue<Direction> que = new LinkedList<>();
    que.add(new Direction(y, x));
 
    while (!que.isEmpty()) {
        Direction cur = que.poll();
        visited[cur.y][cur.x] = -1;
 
        for (Direction d : DIRECTIONS) {
        Direction next = new Direction(cur.y + d.y, cur.x + d.x);
        if (!canMove(next) || visited[next.y][next.x] == -1) {
            continue;
        }
        if (map[next.y][next.x] == 0) {
            visited[next.y][next.x] = -1;
            que.add(next);
            continue;
        }
        visited[next.y][next.x] = -1;
        }
    }
    }
 
    private static void input(final char[][] inputMap) throws IOException {
    for (int y = 0; y < N; y++) {
        inputMap[y] = br.readLine().toCharArray();
    }
    }
 
    private static void calMap(final char[][] inputMap, final int[][] map) {
    for (int y = 0; y < N; y++) {
        for (int x = 0; x < N; x++) {
        Direction cur = new Direction(y, x);
        if (inputMap[cur.y][cur.x] == '*') {
            map[cur.y][cur.x] = -1;
            continue;
        }
        int count = 0;
        for (Direction d : DIRECTIONS) {
            Direction next = new Direction(y + d.y, x + d.x);
            if (!canMove(next))
            continue;
            if (inputMap[next.y][next.x] == '*') {
            count++;
            }
        }
        map[cur.y][cur.x] = count;
        }
    }
    }
 
    private static boolean canMove(final Direction dir) {
    return dir.y >= 0 && dir.y < N && dir.x >= 0 && dir.x < N;
    }
}

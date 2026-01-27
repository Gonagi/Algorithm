import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        List<Integer>[][] childMap = new List[N + 1][N + 1];

        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                childMap[y][x] = new ArrayList<>();
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] list = new int[K + 1][3];
        for (int idx = 1; idx <= K; idx++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            list[idx][0] = y;
            list[idx][1] = x;
            list[idx][2] = dir;

            childMap[y][x].add(idx);
        }

        int[] dy = {0, 0, 0, -1, 1};
        int[] dx = {0, 1, -1, 0, 0};

        int turn = 0;
        while (turn < 1000) {
            turn++;
            for (int idx = 1; idx <= K; idx++) {
                int y = list[idx][0];
                int x = list[idx][1];
                int dir = list[idx][2];

                int nextY = y + dy[dir];
                int nextX = x + dx[dir];

                if (nextY >= 1 && nextY <= N && nextX >= 1 && nextX <= N) {
                    if (map[nextY][nextX] == 0) {
                        int index = childMap[y][x].indexOf(idx);
                        childMap[nextY][nextX].addAll(childMap[y][x].subList(index, childMap[y][x].size()));
                        childMap[y][x] = childMap[y][x].subList(0, index);
                        for (int h : childMap[nextY][nextX]) {
                            list[h][0] = nextY;
                            list[h][1] = nextX;
                        }
                    } else if (map[nextY][nextX] == 1) {
                        int index = childMap[y][x].indexOf(idx);

                        List<Integer> sub = childMap[y][x].subList(index, childMap[y][x].size());
                        Collections.reverse(sub);

                        childMap[nextY][nextX].addAll(sub);
                        childMap[y][x] = childMap[y][x].subList(0, index);

                        for (int h : childMap[nextY][nextX]) {
                            list[h][0] = nextY;
                            list[h][1] = nextX;
                        }
                    } else {
                        int newDir = (dir % 2 == 0) ? dir - 1 : dir + 1;
                        list[idx][2] = newDir;

                        int ny = y + dy[newDir];
                        int nx = x + dx[newDir];

                        if (ny < 1 || ny > N || nx < 1 || nx > N) {
                            continue;
                        }
                        if (map[ny][nx] != 2) {
                            idx--;
                        }
                    }
                    if (childMap[nextY][nextX].size() >= 4) {
                        System.out.println(turn);
                        return;
                    }
                } else {
                    int newDir = (dir % 2 == 0) ? dir - 1 : dir + 1;
                    list[idx][2] = newDir;

                    int ny = y + dy[newDir];
                    int nx = x + dx[newDir];

                    if (ny >= 1 && ny <= N && nx >= 1 && nx <= N && map[ny][nx] != 2) {
                        idx--;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}


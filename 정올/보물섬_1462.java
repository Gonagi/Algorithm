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

    static char[][] map;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        map = new char[R][C];
        for (int y = 0; y < R; y++) {
            String inputX = br.readLine();
            for (int x = 0; x < C; x++) {
                map[y][x] = inputX.charAt(x);
                if (map[y][x] == 'L') {
                    list.add(new Node(y, x));
                }
            }
        }

        int size = list.size();
        for (int idx = 0; idx < size - 1; idx++) {
            Node startNode = list.get(idx);
            boolean[][] visited = new boolean[R][C];
            Queue<Node> que = new ArrayDeque<>();
            que.add(startNode);
            visited[startNode.y][startNode.x] = true;

            int count = 0;
            while (!que.isEmpty()) {
                int qSize = que.size();
                for (int s = 0; s < qSize; s++) {
                    Node curNode = que.poll();
                    max = Math.max(max, count);
                    for (int[] dir : directions) {
                        int nextY = curNode.y + dir[0];
                        int nextX = curNode.x + dir[1];

                        if (nextY >= 0 && nextY < R && nextX >= 0 && nextX < C && !visited[nextY][nextX]
                                && map[nextY][nextX] == 'L') {
                            visited[nextY][nextX] = true;
                            que.add(new Node(nextY, nextX));
                        }
                    }
                }
                count++;
            }
        }

        System.out.println(max);
        br.close();
    }
}


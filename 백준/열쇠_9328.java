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
    static Character[][] map;
    static boolean[][] visited;
    static Set<Character> set;
    static List<Node>[] doors;
    static int h, w, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new Character[h + 2][w + 2];

            for (int y = 0; y < h + 2; y++) {
                Arrays.fill(map[y], '.');
            }

            for (int y = 0; y < h; y++) {
                String inputX = br.readLine();
                for (int x = 0; x < w; x++) {
                    map[y + 1][x + 1] = inputX.charAt(x);
                }
            }

            h += 2;
            w += 2;

            set = new HashSet<>();
            String keys = br.readLine();
            if (!keys.equals("0")) {
                for (int idx = 0; idx < keys.length(); idx++) {
                    set.add(Character.toUpperCase(keys.charAt(idx)));
                }
            }

            visited = new boolean[h][w];
            doors = new ArrayList[26];
            for (int idx = 0; idx < 26; idx++) {
                doors[idx] = new ArrayList<>();
            }
            count = 0;
            bfs(0, 0);

            sb.append(count).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int y, int x) {
        if ('a' <= map[y][x] && map[y][x] <= 'z') {
            set.add(Character.toUpperCase(map[y][x]));
        } else if ('A' <= map[y][x] && map[y][x] <= 'Z') {
            if (!set.contains(map[y][x])) {
                doors[map[y][x] - 'A'].add(new Node(y, x));
                return;
            }
        } else if (map[y][x] == '$') {
            count++;
        }

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(y, x));
        visited[y][x] = true;

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            for (int[] dir : directions) {
                int nextY = curNode.y + dir[0];
                int nextX = curNode.x + dir[1];
                if (!canMove(nextY, nextX) || map[nextY][nextX] == '*' || visited[nextY][nextX]) {
                    continue;
                }
                if ('a' <= map[nextY][nextX] && map[nextY][nextX] <= 'z') {
                    Character key = Character.toUpperCase(map[nextY][nextX]);
                    if (set.add(key)) {
                        for (Node node : doors[key - 'A']) {
                            que.add(node);
                        }
                    }
                } else if ('A' <= map[nextY][nextX] && map[nextY][nextX] <= 'Z') {
                    if (!set.contains(map[nextY][nextX])) {
                        doors[map[nextY][nextX] - 'A'].add(new Node(nextY, nextX));
                        continue;
                    }
                } else if (map[nextY][nextX] == '$') {
                    count++;
                }
                visited[nextY][nextX] = true;
                que.add(new Node(nextY, nextX));
            }

        }
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}


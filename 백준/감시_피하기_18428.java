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

    static int N;
    static char[][] map;
    static List<Node> tList = new ArrayList<>();
    static boolean check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = st.nextToken().charAt(0);
                if (map[y][x] == 'T') {
                    tList.add(new Node(y, x));
                }
            }
        }

        backtrack(0, 0, 0);
        System.out.println(check ? "YES" : "NO");
        br.close();
    }

    private static void backtrack(int curY, int curX, int count) {
        if (count == 3) {
            if (confirm()) {
                check = true;
            }
            return;
        }

        if (check) {
            return;
        }

        for (int y = curY; y < N; y++) {
            for (int x = (y == curY ? curX : 0); x < N; x++) {
                if (map[y][x] == 'X') {
                    map[y][x] = 'O';
                    backtrack(y, x + 1, count + 1);
                    map[y][x] = 'X';
                }
            }
        }
    }

    private static boolean confirm() {
        for (Node node : tList) {
            for (int nextY = node.y; nextY >= 0; nextY--) {
                if (map[nextY][node.x] == 'O') {
                    break;
                }
                if (map[nextY][node.x] == 'S') {
                    return false;
                }
            }

            for (int nextY = node.y; nextY < N; nextY++) {
                if (map[nextY][node.x] == 'O') {
                    break;
                }
                if (map[nextY][node.x] == 'S') {
                    return false;
                }
            }

            for (int nexX = node.x; nexX >= 0; nexX--) {
                if (map[node.y][nexX] == 'O') {
                    break;
                }
                if (map[node.y][nexX] == 'S') {
                    return false;
                }
            }

            for (int nextX = node.x; nextX < N; nextX++) {
                if (map[node.y][nextX] == 'O') {
                    break;
                }
                if (map[node.y][nextX] == 'S') {
                    return false;
                }
            }
        }
        return true;
    }
}


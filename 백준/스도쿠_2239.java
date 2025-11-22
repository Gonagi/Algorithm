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

    static int[][] map = new int[9][9];
    static List<Node> list = new ArrayList<>();
    static boolean solved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int y = 0; y < 9; y++) {
            String input = br.readLine();
            for (int x = 0; x < 9; x++) {
                map[y][x] = input.charAt(x) - '0';
                if (map[y][x] == 0) {
                    list.add(new Node(y, x));
                }
            }
        }

        dfs(0);

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                bw.write(map[y][x] + "");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int depth) {
        if (solved) {
            return;
        }
        if (depth == list.size()) {
            solved = true;
            return;
        }

        Node cur = list.get(depth);

        for (int num = 1; num <= 9; num++) {
            if (possible(cur.y, cur.x, num)) {
                map[cur.y][cur.x] = num;
                dfs(depth + 1);
                if (solved) {
                    return;
                }
                map[cur.y][cur.x] = 0;
            }
        }
    }

    static boolean possible(int y, int x, int num) {
        for (int curX = 0; curX < 9; curX++) {
            if (map[y][curX] == num) {
                return false;
            }
        }

        for (int curY = 0; curY < 9; curY++) {
            if (map[curY][x] == num) {
                return false;
            }
        }

        int curY = (y / 3) * 3;
        int curX = (x / 3) * 3;
        for (int r = curY; r < curY + 3; r++) {
            for (int c = curX; c < curX + 3; c++) {
                if (map[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}


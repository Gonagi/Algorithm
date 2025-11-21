s(0, 0, N, bw);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int y, int x, int size, BufferedWriter bw) throws IOException {
        if (check(y, x, size, 0)) {
            bw.write("0");
        } else if (check(y, x, size, 1)) {
            bw.write("1");
        } else {
            bw.write("(");
            dfs(y, x, size / 2, bw);
            dfs(y, x + size / 2, size / 2, bw);
            dfs(y + size / 2, x, size / 2, bw);
            dfs(y + size / 2, x + size / 2, size / 2, bw);
            bw.write(")");

        }
    }

    private static boolean check(int y, int x, int size, int num) {
        for (int r = y; r < y + size; r++) {
            for (int c = x; c < x + size; c++) {
              import java.io.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int y = 0; y < N; y++) {
            String input = br.readLine();
            for (int x = 0; x < N; x++) {
                map[y][x] = input.charAt(x) - '0';
            }
        }

        if (check(0, 0, N, 0)) {
            bw.write("0");
        } else if (check(0, 0, N, 1)) {
            bw.write("1");
        } else {
            df  if (map[r][c] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}


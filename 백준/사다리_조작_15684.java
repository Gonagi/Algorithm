import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] ladder;
    static int N, M, H, min = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 1];

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        dfs(1, 0);

        if (min == 4) {
            bw.write("-1\n");
        } else {
            bw.write(min + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int start, int count) {
        if (count > 3) {
            return;
        }

        if (check()) {
            min = Math.min(min, count);
            return;
        }

        for (int y = start; y <= H; y++) {
            for (int x = 1; x < N; x++) {
                if (ladder[y][x] || ladder[y][x - 1] || ladder[y][x + 1]) {
                    continue;
                }
                ladder[y][x] = true;
                dfs(y, count + 1);
                ladder[y][x] = false;
            }
        }
    }

    private static boolean check() {
        for (int x = 1; x <= N; x++) {
            int idx = x;
            for (int y = 1; y <= H; y++) {
                if (ladder[y][idx]) {
                    idx++;
                } else if (idx >= 2 && ladder[y][idx - 1]) {
                    idx--;
                }
            }
            if (idx != x) {
                return false;
            }
        }
        return true;
    }
}


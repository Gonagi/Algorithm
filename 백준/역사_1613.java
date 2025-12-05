import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int idx = 0; idx < k; idx++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());
            map[prev][post] = true;
        }

        for (int x = 1; x <= n; x++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][x] && map[x][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }
        int s = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < s; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (map[from][to]) {
                bw.write("-1\n");
            } else if (map[to][from]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


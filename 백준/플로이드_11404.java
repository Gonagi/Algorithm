import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] result;
    static List<Integer>[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        result = new int[n + 1][n + 1];

        for (int idx = 1; idx <= n; idx++) {
            Arrays.fill(result[idx], 987654321);
            result[idx][idx] = 0;
        }

        for (int idx = 0; idx < m; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            result[start][end] = Math.min(result[start][end], cost);
        }

        for (int middle = 1; middle <= n; middle++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (result[start][end] > result[start][middle] + result[middle][end]) {
                        result[start][end] = result[start][middle] + result[middle][end];
                    }
                }
            }
        }

        for (int start = 1; start <= n; start++) {
            for (int end = 1; end <= n; end++) {

                bw.write((result[start][end] == 987654321 ? 0 : result[start][end]) + " ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


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

    static int N, W;
    static Node[] events;
    static int[][] dp;
    static int[][] choice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        choice = new int[W + 1][W + 1];

        events = new Node[W + 1];
        for (int idx = 1; idx <= W; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            events[idx] = new Node(y, x);
        }

        dp = new int[W + 1][W + 1];
        for (int i = 0; i <= W; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = solve(0, 0);
        bw.write(String.valueOf(result));
        bw.newLine();

        int a = 0, b = 0;
        for (int i = 1; i <= W; i++) {
            int c = choice[a][b];
            bw.write(String.valueOf(c));
            bw.newLine();
            if (c == 1) {
                a = i;
            } else {
                b = i;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int solve(int a, int b) {
        int next = Math.max(a, b) + 1;

        if (next > W) {
            return 0;
        }

        if (dp[a][b] != -1) {
            return dp[a][b];
        }

        int cost1 = solve(next, b) + dist1(a, next);
        int cost2 = solve(a, next) + dist2(b, next);

        if (cost1 < cost2) {
            choice[a][b] = 1;
            return dp[a][b] = cost1;
        } else {
            choice[a][b] = 2;
            return dp[a][b] = cost2;
        }
    }

    private static int dist1(int a, int b) {
        Node A = (a == 0) ? new Node(1, 1) : events[a];
        Node B = events[b];
        return Math.abs(A.y - B.y) + Math.abs(A.x - B.x);
    }

    private static int dist2(int a, int b) {
        Node A = (a == 0) ? new Node(N, N) : events[a];
        Node B = events[b];
        return Math.abs(A.y - B.y) + Math.abs(A.x - B.x);
    }
}

